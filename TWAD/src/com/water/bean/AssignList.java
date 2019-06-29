package com.water.bean;

import java.util.ArrayList;

public class AssignList extends ArrayList<LoginBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3717586141080243207L;

	private LoginBean loginBean;

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
