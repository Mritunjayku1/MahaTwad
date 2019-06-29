package com.water.bean;

import java.util.ArrayList;

public class ComplaintBeanList extends ArrayList<ComplaintBean> {

	private static final long serialVersionUID = 201008589716166819L;
	private ComplaintBean complaintBean;

	public ComplaintBean getComplaintBean() {
		return complaintBean;
	}

	public void setComplaintBean(ComplaintBean complaintBean) {
		this.complaintBean = complaintBean;
	}

}
