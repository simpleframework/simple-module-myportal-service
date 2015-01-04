package net.simpleframework.module.myportal;

import java.util.Collection;

import net.simpleframework.common.ID;
import net.simpleframework.ctx.service.ado.db.IDbBeanService;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public interface ITabService extends IDbBeanService<TabBean> {

	/**
	 * 获取指定用户缺省的门户页面
	 * 
	 * @param rRequest
	 * @param accountId
	 * @return
	 */
	TabBean homeTab(ID accountId);

	/**
	 * 获取我的门户标签列表
	 * 
	 * @param rRequest
	 * @return
	 */
	Collection<TabBean> queryTabs(ID accountId);
}
