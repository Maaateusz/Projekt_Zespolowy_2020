package com.pz.ankietBud.configuration;

import com.pz.ankietBud.model.Survey;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableAsync
public class ScheduledTasks {

//    @Async
////    @Scheduled(fixedRate = 10 * 1000)
//    @Scheduled(cron = "0 0 23 1 * ?")
//    public void scheduleFixedRateTaskAsync() throws InterruptedException {
//        System.out.println(
//                "Monthly task - " + System.currentTimeMillis() / 1000);
//        Thread.sleep(2000);
//    }

}
