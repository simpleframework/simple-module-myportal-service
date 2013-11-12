package net.simpleframework.module.myportal.impl;

import java.io.Serializable;

import net.simpleframework.ctx.service.ado.db.AbstractDbBeanService;
import net.simpleframework.module.myportal.IMyPortalContextAware;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public abstract class AbstractPortalService<T extends Serializable> extends
		AbstractDbBeanService<T> implements IMyPortalContextAware {

	protected PortalTabService getPortalTabService() {
		return (PortalTabService) context.getPortalTabService();
	}

	protected LayoutLobService getMyPortalService() {
		return (LayoutLobService) context.getMyPortalService();
	}
}
