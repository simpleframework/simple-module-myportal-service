package net.simpleframework.module.myportal.impl;

import static net.simpleframework.common.I18n.$m;
import net.simpleframework.ado.IADOManagerFactory;
import net.simpleframework.ado.db.DbManagerFactory;
import net.simpleframework.ctx.AbstractADOModuleContext;
import net.simpleframework.ctx.IApplicationContext;
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
public abstract class MyPortalContext extends AbstractADOModuleContext implements IMyPortalContext {

	@Override
	public void onInit(final IApplicationContext application) throws Exception {
		super.onInit(application);

		final IADOManagerFactory aFactory = getADOManagerFactory();
		if (aFactory instanceof DbManagerFactory) {
			((DbManagerFactory) aFactory).regist(PortalTabBean.TBL, LayoutLobBean.TBL);
		}
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
