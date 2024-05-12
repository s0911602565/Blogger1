package com.lee.springbootworkspaceblogger.util.quartz;


import org.quartz.*;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail showTime() {
        System.out.println("showTime方法");
        return JobBuilder.newJob(QuartzJob.class)
                .withIdentity("排程1")//給當前的JobDetail取名字
                .storeDurably()
                .build();
    }

    //觸發器
    @Bean
    public Trigger showTimeTrigger() {
        System.out.println("showTimeTrigger方法");
        CronScheduleBuilder cronScheduleBuilder =
                CronScheduleBuilder.cronSchedule("0/5 * * * * ? ");//每5秒執行一次
        return TriggerBuilder.newTrigger()
                .forJob(showTime())
                .withIdentity("redisUpdateTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
