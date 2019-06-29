package com.water.quartz;

import java.util.ResourceBundle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzSchedulerListener implements ServletContextListener {

	String ActiveStatus;
	String ActiveExp;
	String EscalationStatus;
	String EscalationStatusExp;
	
	String EpicStatus;
	String EpicInterval;

	ResourceBundle rb = ResourceBundle.getBundle("resources/constant");

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< QUARTZ LISTENER DESTROYED.............. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		System.out
				.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< QUARTZ LISTENER LISTENED.............. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		this.ActiveStatus = rb.getString("ActiveStatus");
		this.ActiveExp = rb.getString("ActionExp");
		this.EscalationStatus = rb.getString("EscalationStatus");
		this.EscalationStatusExp = rb.getString("EscalationStatusExp");
		this.EpicStatus=rb.getString("EpicStatus");
		this.EpicInterval=rb.getString("EpicInterval");

		try {

			if (ActiveStatus.equals("1")) {

				JobKey jobKeyA = new JobKey("JobName", "JobNameGroup");
				JobDetail jobA = JobBuilder.newJob(JobClassName.class)
						.withIdentity(jobKeyA).build();
				Trigger trigger1 = TriggerBuilder
						.newTrigger()
						.withIdentity("JobName", "JobNameGroup")
						.withSchedule(
								CronScheduleBuilder.cronSchedule(ActiveExp))
						.build();
				Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
				scheduler1.start();
				scheduler1.scheduleJob(jobA, trigger1);
			}

			if (EscalationStatus.equals("1")) {

				JobKey jobKeyB = new JobKey("JobName1", "JobNameGroup1");
				JobDetail jobB = JobBuilder.newJob(EscalationJob.class)
						.withIdentity(jobKeyB).build();
				Trigger trigger2 = TriggerBuilder
						.newTrigger()
						.withIdentity("JobName1", "JobNameGroup1")
						.withSchedule(
								CronScheduleBuilder
										.cronSchedule(EscalationStatusExp))
						.build();
				Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
				scheduler2.start();
				scheduler2.scheduleJob(jobB, trigger2);
			}

			if (EpicStatus.equals("1")) {

				JobKey jobKeyB = new JobKey("JobEpic", "JobEpicGroup");
				JobDetail jobB = JobBuilder.newJob(EPICSchedluer.class)
						.withIdentity(jobKeyB).build();
				Trigger trigger2 = TriggerBuilder
						.newTrigger()
						.withIdentity("JobEpic", "JobEpicGroup")
						.withSchedule(
								CronScheduleBuilder
										.cronSchedule(EpicInterval))
						.build();
				Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
				scheduler2.start();
				scheduler2.scheduleJob(jobB, trigger2);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
