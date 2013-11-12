package net.simpleframework.module.myportal;

import net.simpleframework.ado.bean.AbstractUserAwareBean;
import net.simpleframework.ado.db.DbEntityTable;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885)
 *         http://code.google.com/p/simpleframework/
 *         http://www.simpleframework.net
 */
public class PortalTabBean extends AbstractUserAwareBean {
	private String tabText;

	private ETabMark tabMark;

	private int views;

	private String description;

	public String getTabText() {
		return tabText;
	}

	public void setTabText(final String tabText) {
		this.tabText = tabText;
	}

	public ETabMark getTabMark() {
		return tabMark == null ? ETabMark.normal : tabMark;
	}

	public void setTabMark(final ETabMark tabMark) {
		this.tabMark = tabMark;
	}

	public int getViews() {
		return views;
	}

	public void setViews(final int views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public static final DbEntityTable TBL = new DbEntityTable(PortalTabBean.class,
			"sf_my_portal_tabs");

	private static final long serialVersionUID = 8142966150870802569L;
}
