package com.water.dao;

import java.util.List;

import com.water.bean.ApplicationBean;
import com.water.bean.CmwWaterConnBean;
import com.water.bean.CompanyDtlBean;
import com.water.bean.DDPaymentFormBean;
import com.water.bean.PaymentFormBean;
import com.water.model.Application;
import com.water.model.CompanyDtl;

public interface DashboardDao {
	
	
	public Application getApplicationDtls(ApplicationBean appFormBean);
	public Application getApplicationDetails(ApplicationBean appFormBean);
	public List<Application> listCePendingApplicationDtls();
	public List<Application> listceApprovedApplicationDtls();
	public List<Application> listEeApprovedApplicationDtls();
	public String addPayment(PaymentFormBean paymentFormBean );
	public String eeAddPayment(PaymentFormBean paymentFormBean );
	public String eeAddFullPayment(PaymentFormBean paymentFormBean );
	public List<DDPaymentFormBean> registeredApplication();
	public List<DDPaymentFormBean> approvedApplication();
	public List<DDPaymentFormBean> transferApplication();
	public List<DDPaymentFormBean> rejectedApplication();
	public List<DDPaymentFormBean> paymentPendingList();
	public List<DDPaymentFormBean> paymentRejectedList();
	public List<DDPaymentFormBean> paymentApprovedList();
	public List<CompanyDtl> ddPaymentViewAllList();
	public CompanyDtl paymentViewForm(DDPaymentFormBean ddPaymentFormBean);
	public List<Application> listViewAllApplication();
	
	public List<DDPaymentFormBean> eeApplicationFeePending(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeUpfrontChargesPending(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeFullPaymentPending(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eePaymentPending(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eePaymentCompleted(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeInspectedApplication(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeMCApproved(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeFullPaymentCompleted(CompanyDtlBean companyDtlBean);
	public List<DDPaymentFormBean> eeExecution(CompanyDtlBean companyDtlBean);
	public List<CompanyDtl> listMOU();
	public List<CompanyDtl> listEstimate();
	public List<CompanyDtl> listAfterInspection();
	public List<Application> listConPaidDtls();
	public List<Application> listConPendingPayment();
	public List<Application> listInitialPendingPayment();
	
	public List<Application> listProsFeePendingPayment();
	public String  ceApproved(ApplicationBean applicationBean);
	public String  paymentApproved(ApplicationBean applicationBean);
	
	public List<Object[]> getceDashboardCount();
	public List<Object[]> geteeDashboardCount(CompanyDtlBean companyDtlBean);
	public String getMCDashboardCount();
	public List<Object[]> getPaymentDashboardCount();
	
	
	public List<Object[]> getPublicDashboardCount(ApplicationBean applicationBean);
	
	
	public List<Application> listEePaymentPendingApplicationDtls();
	public List<DDPaymentFormBean> listMcPendingApplicationDtls();
	public List<Application> listTrackApplication();
	public List<Application> listMcApprovedApplicationDtls();
	public List<Application> listEePendingApplicationDtls();
	public String  sendInitialPaymentCost(ApplicationBean applicationBean);
	public String  isMcDicision(ApplicationBean applicationBean);
	public String  isMcTrckDicision(ApplicationBean applicationBean);
	
	
	
	public String  SendInspectionDate(CompanyDtlBean applicationBean);
	
	public String  sendBeforeInspectionDate(ApplicationBean applicationBean);
	public String  eeAfterInspectionApproved(ApplicationBean applicationBean);
	public String  eeAfterInspectionRejected(ApplicationBean applicationBean);
	public String  eeFinalApproved(ApplicationBean applicationBean);
	public String  eeRejected(ApplicationBean applicationBean);
	public String  eeWidthdraw(ApplicationBean applicationBean);
	public String  SendEstimationCost(ApplicationBean applicationBean);
	public String  SendOracleDb(CmwWaterConnBean cmwWaterConnBean);
	
	

}
