package net.simpleframework.module.myportal;

import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ILayoutLobService extends IDbBeanService<LayoutLobBean> {

	/**
	 * 获取布局xml内容
	 * 
	 * @param tab
	 * @return
	 */
	LayoutLobBean getLayoutLob(TabBean tab);
}
