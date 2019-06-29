package com.water.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobClassName implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		EmailComplaint obj = new EmailComplaint();
		obj.MethodEmail();

	}

}
