package net.simpleframework.module.myportal.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.db.DbEntityTable;
import net.simpleframework.ado.db.IDbEntityTableRegistry;
import net.simpleframework.ctx.AbstractADOModuleContext;
import net.simpleframework.ctx.Module;
import net.simpleframework.module.myportal.ILayoutLobService;
import net.simpleframework.module.myportal.IMyPortalContext;
import net.simpleframework.module.myportal.IPortalTabService;
import net.simpleframework.module.myportal.LayoutLobBean;
import net.simpleframework.module.myportal.PortalTabBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public abstract class MyPortalContext extends AbstractADOModuleContext implements IMyPortalContext,
		IDbEntityTableRegistry {
	@Override
	public DbEntityTable[] createEntityTables() {
		return new DbEntityTable[] { new DbEntityTable(PortalTabBean.class, "sf_my_portal_tabs"),
				new DbEntityTable(LayoutLobBean.class, "sf_my_portal_layout").setNoCache(true) };
	}

	@Override
	protected Module createModule() {
		return new Module().setName(MODULE_NAME).setText($m("MyPortalContext.0")).setOrder(37);
	}

	@Override
	public IPortalTabService getPortalTabService() {
		return singleton(PortalTabService.class);
	}

	@Override
	public ILayoutLobService getMyPortalService() {
		return singleton(LayoutLobService.class);
	}
}
