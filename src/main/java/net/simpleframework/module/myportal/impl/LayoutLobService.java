package net.simpleframework.module.myportal.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import net.simpleframework.common.ClassUtils;
import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.myportal.ILayoutLobService;
import net.simpleframework.module.myportal.IMyPortalContextAware;
import net.simpleframework.module.myportal.LayoutLobBean;
import net.simpleframework.module.myportal.LayoutTabBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class LayoutLobService extends AbstractDbBeanService<LayoutLobBean> implements
		ILayoutLobService, IMyPortalContextAware {

	@Override
	public LayoutLobBean getLayoutLob(final LayoutTabBean tab) {
		LayoutLobBean lob = getBean(tab.getId());
		if (lob == null) {
			lob = new LayoutLobBean();
			lob.setId(tab.getId());
			try {
				final InputStream is = ClassUtils.getResourceRecursively(PortalTabService.class,
						"template_" + tab.getTabMark().name() + ".xml");
				lob.setLayoutLob(new InputStreamReader(is, "utf-8"));
			} catch (final UnsupportedEncodingException e) {
			}
			insert(lob);
		}
		return lob;
	}
}
