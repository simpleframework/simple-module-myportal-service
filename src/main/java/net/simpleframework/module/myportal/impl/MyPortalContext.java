package net.simpleframework.module.myportal.impl;

import static net.simpleframework.common.I18n.$m;

import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ctx.AbstractADOModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.ctx.permission.PermissionConst;
import net.simpleframework.module.myportal.ILayoutLobService;
import net.simpleframework.module.myportal.IMyPortalContext;
import net.simpleframework.module.myportal.ITabService;
import net.simpleframework.module.myportal.LayoutLobBean;
import net.simpleframework.module.myportal.TabBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class MyPortalContext extends AbstractADOModuleContext implements IMyPortalContext {

	@Override
	protected DbEntityTable[] createEntityTables() {
		return new DbEntityTable[] { new DbEntityTable(TabBean.class, "sf_my_portal_tabs"),
				new DbEntityTable(LayoutLobBean.class, "sf_my_portal_layout").setNoCache(true) };
	}

	@Override
	protected Module createModule() {
		return super.createModule().setManagerRole(PermissionConst.ROLE_ALL_ACCOUNT)
				.setName(MODULE_NAME).setText($m("MyPortalContext.0")).setOrder(37);
	}

	@Override
	public ITabService getTabService() {
		return singleton(PortalTabService.class);
	}

	@Override
	public ILayoutLobService getLayoutLobService() {
		return singleton(LayoutLobService.class);
	}
}
