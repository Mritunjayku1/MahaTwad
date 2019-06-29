package com.water.bean;

import java.util.ArrayList;

public class DashboardBeanList extends ArrayList<DashboardBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1072195802307756959L;
	private DashboardBean dashboardBean;

	public DashboardBean getDashboardBean() {
		return dashboardBean;
	}

	public void setDashboardBean(DashboardBean dashboardBean) {
		this.dashboardBean = dashboardBean;
	}

}
