package com.water.listener;

import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mchange.v2.c3p0.C3P0Registry;
import com.mchange.v2.c3p0.PooledDataSource;

public class CustomListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
		Set<PooledDataSource> pooledDataSourceSet = (Set<PooledDataSource>) C3P0Registry
				.getPooledDataSources();

		for (PooledDataSource dataSource : pooledDataSourceSet) {
			try {
				dataSource.hardReset();
				dataSource.close();
			} catch (SQLException e) {
				
				System.out
						.println("Unable to hard reset and close data source.");
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
	
		System.out.println("Context Initialized");
	}

}
