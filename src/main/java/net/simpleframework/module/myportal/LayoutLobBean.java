package net.simpleframework.module.myportal;

import java.io.Reader;

import net.simpleframework.ado.bean.AbstractIdBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
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

	private static final long serialVersionUID = 6391781294365189653L;
}
