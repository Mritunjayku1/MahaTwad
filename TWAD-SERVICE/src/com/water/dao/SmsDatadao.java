package com.water.dao;

import java.util.List;

import com.water.bean.SmsDatas;
import com.water.model.CompanyDtl;
import com.water.model.EmployeeDetails;

public interface SmsDatadao {

	public String smsData(String sender, String message);

	public SmsDatas receiveSMs(String sender, String message);

	List<CompanyDtl> getTemplateID(String applicationId,Integer applicationID);
	List<EmployeeDetails> getTemplateIDtoEE(String applicationId,Integer applicationID);
	
	
}
