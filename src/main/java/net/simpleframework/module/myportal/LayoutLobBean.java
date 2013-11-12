package net.simpleframework.module.myportal;

import java.io.Reader;

import net.simpleframework.ado.bean.AbstractIdBean;
import net.simpleframework.ado.db.DbEntityTable;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class LayoutLobBean extends AbstractIdBean {

	private Reader layoutLob;

	public Reader getLayoutLob() {
		return layoutLob;
	}

	public void setLayoutLob(final Reader layoutLob) {
		this.layoutLob = layoutLob;
	}

	public static final DbEntityTable TBL = new DbEntityTable(LayoutLobBean.class,
			"sf_my_portal_layout").setNoCache(true);

	private static final long serialVersionUID = 6391781294365189653L;
}
