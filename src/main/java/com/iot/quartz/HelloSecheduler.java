package com.iot.quartz;

import lombok.Data;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author:pang
 * @Description:
 * @Date:Creat In:10:55 2018/7/23
 * @Modified By:
 */
@Data
public class HelloSecheduler {

    public void run(){
        /*创建一个jobDetail实例，将该实例和HelloJod类绑定*/
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).
                withIdentity("myJob","group1").build();

        //创建Trigger实例，设置立即执行，直到永远。
        Trigger trigger=TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5).repeatForever()
                )
                .build();


        //创建scheduler实例
        SchedulerFactory sfact=new StdSchedulerFactory();
        try {
            Scheduler scheduler=sfact.getScheduler();
            scheduler.start();
            scheduler.scheduleJob(jobDetail,trigger);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
