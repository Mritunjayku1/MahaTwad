/**
 * 
 */
package com.water.util;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.water.model.Application;

/**
 * @author Mahalingam
 * 
 *         Class contains constant values which can be used throughout the
 *         application.
 * 
 *         Created by Mahalingam on 27-May-2017
 * 
 *         SQL Query for entire application.
 */
public class Constant {

			
	public static final String Get_PaymentDashboardCount="select * from (select count(*) as approvedApplication from CompanyDtl where DIVISION_ID is not null ) as b, (select count(*) as rejectedApplication from CompanyDtl where ACTIVE=0 ) as c, (select count(*) as pendingApplication from CompanyDtl a inner join CompanyPaymentDtl b on a.APP_ID=b.APP_ID where a.DIVISION_ID is null and b.PAYMENT_AMOUNT is not null and b.PAYMENT_TYPE_ID=1  ) as d";
	public static final String Get_EEDashboardCount="select * from (select count(*) as applicationFeePending from CompanyDtl where EE_STATUS=1 and ACTIVE=2 and DIVISION_ID=:divisionId ) as b, (select count(*) as upfrontChargesPending from CompanyDtl where EE_STATUS=2 and ACTIVE=2 and DIVISION_ID=:divisionId ) as c, (select count(*) as fullPaymentPending from CompanyDtl where EE_STATUS=3 and ACTIVE=2 and DIVISION_ID=:divisionId) as d, (select count(*) as fullPaymentCompleted from CompanyDtl where EE_STATUS=4 and ACTIVE=2 and DIVISION_ID=:divisionId) as e, (select count(*) as execution from CompanyDtl where EE_STATUS=5 and ACTIVE=2 and DIVISION_ID=:divisionId) as f ";
	public static final String Get_MCDashboardCount="select count(*) as pendingApplication from companydtl a left outer join master_payment b on a.app_id = b.app_id where a.active=3 and b.payment_type_id=3" ;
	public static final String Get_CEDashboardCount="select distinct (select count(ee_status) from app where  status_flag<>'E' and status_flag<>'F'  ) as register,(select count(ee_status) from app where ee_status=1 and status_flag='Y' and INS_STATUS_ID=1 and PAID_PROCESSING_FEE is not null  ) as pending ,(select count(ee_status) from app where mc_status=3 and status_flag='Y') as Approved,(select count(ee_status) from app where status_flag='P' and INS_STATUS_ID=4 ) as paid from app group by ce_status";
	
	//public static final String Get_EEDashboardCount="select distinct (select count(ee_status) from app where  status_flag<>'E' and status_flag<>'F' ) as register,(select count(ee_status) from app where ce_status=1 and INS_STATUS_ID=1 and status_flag='Y'  ) as pending ,(select count(ee_status) from app where ee_status=3 and status_flag='Y' and  INS_STATUS_ID=3 ) as Approved,(select count(ee_status) from app where  status_flag='P' and INS_STATUS_ID=4 ) as paid from app group by ce_status";
	
	//public static final String Get_MCDashboardCount="select distinct (select count(ee_status) from app where  status_flag<>'E' and status_flag<>'F' ) as register,(select count(mc_status) from app where mc_status=2 ) as pending ,(select count(mc_status) from app where mc_status=3 and   status_flag='Y') as Approved ,(select count(ee_status) from app where status_flag='P' and INS_STATUS_ID=4 ) as paid from app group by ce_status";
	
	public static final String Get_SMSTemplate="select app_id as appid,mobile_number as toMobilenumber,'TemplateType' as temptype,'body' as bodymessage,email_addr as emailId from app where app_id=:applicationId  ";
	
	public static final String FieldOfficer_Escalation_Select = "";

	public static final String Get_ComplaintDtls = " ";

	public static final String Get_publicdashboardCount = " select  FieldCodeID,DerivedValue,coalesce( CategoryCount,0) as Count ,MFC.icon,MFC.color "
			+ "from (Select tblComplaintDetails.ComplaintCategoryID as CategoryID,tblMasterFieldCode.DerivedValue as CategoryName,count(tblComplaintDetails.ComplaintCategoryID) as CategoryCount,Icon "
			+ "from tblComplaintDetails Left JOIN  tblMasterFieldCode on tblMasterFieldCode.FieldCodeID=tblComplaintDetails.ComplaintCategoryID "
			+ "WHERE 1=1 ";

	public static final String Get_publicdashboardCount_1 = " "; 
	
	public static final String smsProcessingFee="1";
	
	public static final String appRegister = " ";
	
	public static final String Update_Complaint = "";
	public static final String Update_ReAssign = "";

	public static final String Reject_Complaint = "";
	public static final String FieldOfficer_ComplaintClose ="";
	public static final String FieldOfficer_Acknowledge =""; 
	public static final String Agent_ComplaintClose = "";
	
	
}
