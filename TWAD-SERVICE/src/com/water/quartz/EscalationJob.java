package com.water.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.water.bean.ComplaintBean;
import com.water.daoImpl.ComplaintDaoImpl;
import com.google.gson.Gson;

public class EscalationJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		System.out.println(" Escalation Trigger >>>>>>>>>>>>>>>>>>>>>>>>>>");

		ComplaintDaoImpl obj = new ComplaintDaoImpl();
		ComplaintBean bean;

		for (Object[] templateData : obj.listEscalatedComplaints()) {
			bean = new ComplaintBean();
			bean.setComplaintID(Integer.parseInt(templateData[0].toString()));
			bean.setComplaintEscalationLevel(Integer.parseInt(templateData[1]
					.toString()));
			bean.setAssignedOfficerID(Integer.parseInt(templateData[2]
					.toString()));
			bean.setComplaintStatus(Integer.parseInt(templateData[3].toString()));
			if ("".equals(templateData[4]) || templateData[4] == null) {
				bean.setComplaintEscalated(Boolean.parseBoolean("0"));
			} else {
				bean.setComplaintEscalated(true);
			}
			System.out.println("Sched" + new Gson().toJson(bean));
		
		}

	}
}
