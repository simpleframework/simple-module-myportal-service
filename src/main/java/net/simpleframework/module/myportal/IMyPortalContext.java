package net.simpleframework.module.myportal;

import net.simpleframework.ctx.service.ado.db.IDbModuleContext;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public interface IMyPortalContext extends IDbModuleContext {

	static final String MODULE_NAME = "simple-module-myportal";

	/**
	 * 获取我的门户标签页管理器
	 * 
	 * @return
	 */
	IPortalTabService getPortalTabService();

	/**
	 * 获取门户布局管理器
	 * 
	 * @return
	 */
	ILayoutLobService getMyPortalService();
}
