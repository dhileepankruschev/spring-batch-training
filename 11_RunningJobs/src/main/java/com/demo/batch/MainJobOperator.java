package com.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobFactory;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.batch.sample.ApplicationConfiguration;
import com.demo.batch.util.MainHelper;


@Component
public class MainJobOperator {

//    @Autowired
//    JobFactory jobFactory;
//    @Autowired
//    JobRegistry jobRegistry;
    @Autowired
    JobOperator jobOperator;

    @Autowired
    Job importUserJob;

    public static void main(String... args) throws JobParametersInvalidException, JobInstanceAlreadyExistsException, NoSuchJobException, DuplicateJobException, NoSuchJobExecutionException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        MainJobOperator main = context.getBean(MainJobOperator.class);
        
        Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Testing stop ******************");
				try {
					main.jobOperator.stop(1);
				} catch (NoSuchJobExecutionException | JobExecutionNotRunningException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
        	
        });
        t1.start();
        
//        main.jobRegistry.register(main.jobFactory);
        long executionId = main.jobOperator.start(main.importUserJob.getName(), null);
        
        
        try {
        	
        	System.out.println("Testing stop ******************");
			main.jobOperator.stop(executionId);
		} catch (JobExecutionNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        MainHelper.reportResults(main.jobOperator, executionId);
        MainHelper.reportPeople(context.getBean(JdbcTemplate.class));

        

        System.out.printf("\nFIN %s", main.getClass().getName());
        
        context.registerShutdownHook();

    }
}
