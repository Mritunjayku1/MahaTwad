package com.water.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class EPICSchedluer implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub

		ReadEpicNo obj = new ReadEpicNo();
		obj.MethodEmail();

	}

}
