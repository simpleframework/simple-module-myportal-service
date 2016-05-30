package net.simpleframework.module.myportal.impl;

import static net.simpleframework.common.I18n.$m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import net.simpleframework.ado.IParamsValue;
import net.simpleframework.ado.db.IDbEntityManager;
import net.simpleframework.ado.query.IDataQuery;
import net.simpleframework.common.ID;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.myportal.ETabMark;
import net.simpleframework.module.myportal.ILayoutLobService;
import net.simpleframework.module.myportal.IMyPortalContextAware;
import net.simpleframework.module.myportal.ITabService;
import net.simpleframework.module.myportal.TabBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class PortalTabService extends AbstractDbBeanService<TabBean>
		implements ITabService, IMyPortalContextAware {

	private TabBean createHomeTab(final ID accountId) {
		final TabBean tab = createBean();
		tab.setUserId(accountId);
		tab.setCreateDate(new Date());
		tab.setTabMark(ETabMark.home);
		tab.setTabText($m("MyPortalContext.0"));
		return tab;
	}

	@Override
	public TabBean homeTab(final ID accountId) {
		if (accountId == null) {
			return null;
		}
		TabBean tab = getBean("userid=? and tabmark=?", accountId, ETabMark.home);
		if (tab == null) {
			insert(tab = createHomeTab(accountId));
		}
		return tab;
	}

	@Override
	public Collection<TabBean> queryTabs(final ID accountId) {
		final ArrayList<TabBean> al = new ArrayList<TabBean>();
		if (accountId != null) {
			final IDataQuery<TabBean> qs = query("userId=? order by tabmark desc", accountId);
			boolean homeTab = false;
			TabBean tab;
			while ((tab = qs.next()) != null) {
				al.add(tab);
				if (tab.getTabMark() == ETabMark.home) {
					homeTab = true;
				}
			}
			if (!homeTab) {
				insert(tab = createHomeTab(accountId));
				al.add(0, tab);
			}
		}
		return al;
	}

	@Override
	public void onInit() throws Exception {
		super.onInit();

		final ILayoutLobService lobService = myPortalContext.getLayoutLobService();
		addListener(new DbEntityAdapterEx<TabBean>() {
			@Override
			public void onAfterDelete(final IDbEntityManager<TabBean> manager,
					final IParamsValue paramsValue) throws Exception {
				super.onAfterDelete(manager, paramsValue);
				for (final TabBean tab : coll(manager, paramsValue)) {
					lobService.delete(tab.getId());
				}
			}

			@Override
			public void onAfterInsert(final IDbEntityManager<TabBean> service, final TabBean[] beans)
					throws Exception {
				super.onAfterInsert(service, beans);
				for (final TabBean bean : beans) {
					lobService.getLayoutLob(bean);
				}
			}
		});
	}
}
