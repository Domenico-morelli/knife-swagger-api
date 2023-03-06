package it.its.nttdata.demo.scheduling;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@EnableScheduling
public class SchedulerApi {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	//0 */5 * ? * *	Every 5 minutes
	// 0 * * ? * * Every min
	@Scheduled(cron = "* * * ? * *") // every sec
	@RequestMapping("/scheduledPostKnifeJobCall")
	public void scheduledPostKnifeJobCall() {
		try {
			JobParameters params = new JobParametersBuilder().addString("idJob", String.valueOf(System.currentTimeMillis())).toJobParameters();
			jobLauncher.run(job, params);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

}
