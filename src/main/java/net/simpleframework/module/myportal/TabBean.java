package net.simpleframework.module.myportal;

import net.simpleframework.ado.bean.AbstractUserAwareBean;

/**
 * Licensed under the Apache License, Version 2.0
 * 
 * @author 陈侃(cknet@126.com, 13910090885) https://github.com/simpleframework
 *         http://www.simpleframework.net
 */
public class TabBean extends AbstractUserAwareBean {
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

	private static final long serialVersionUID = 8142966150870802569L;
}
