package com.water.dao;

import java.util.List;

import com.water.bean.ComplaintBean;
import com.water.bean.DocumentBean;
import com.water.model.ComplaintDetails;

/**
 * @author Mahalingam
 * 
 *         ComplaintDao.java
 * 
 *         Created by Mahalingam (Freelancer) On 02-June-2017
 * 
 *         This Interface is used for Complaint
 * 
 */
public interface ComplaintDao {

	/**
	 * @param complaintBean
	 * @return ComplaintDetails
	 */
	
	public ComplaintDetails updateDocumentInfo(ComplaintBean complaintBean);

	

	public List<Object[]> getDashboardCount();

	

	List<Object[]> listEscalatedComplaints();

	public List<Object[]> getPublicDashboardCount(ComplaintBean complaintBean);

}
