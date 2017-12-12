package com.slp.toolutil;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TaskUtil {

	@Scheduled(cron = "0 0/1 * * * ?")
	public void Task1() {
		// System.out.println(DateUtil.GetDateTime());
	}
}
