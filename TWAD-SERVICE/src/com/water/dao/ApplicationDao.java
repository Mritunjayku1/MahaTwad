package com.water.dao;

import com.water.bean.AppFormBean;
import com.water.bean.AppRegBean;
import com.water.model.Application;

public interface ApplicationDao {

	Application appRegister(AppFormBean appFormBean);

	Application saveApplication(Application application);

	Application getPaymentAmount(AppFormBean appFormBean);
	Application getGstAmounts(AppFormBean appFormBean);
	

	String callEasyBusiness(AppFormBean appFormBean);

	String getReqMLDCost(AppFormBean appFormBean);

	Application getApplicationDtls(AppFormBean appFormBean);
	String getGstAmount(AppFormBean appFormBean);
	String getTotalAmount(AppFormBean appFormBean);
	

}
