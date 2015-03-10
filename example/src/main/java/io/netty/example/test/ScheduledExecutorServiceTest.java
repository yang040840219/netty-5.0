package io.netty.example.test;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangxiaolong on 2015/3/1.
 */
public class ScheduledExecutorServiceTest {

    public ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(1);

    //启动计时器
    public void lanuchTimer() {
        Runnable task = new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date()) ;
            }
        };
        scheduExec.scheduleAtFixedRate(task, 1000 * 5, 1000 * 10, TimeUnit.MILLISECONDS);
    }

    public void addOneTask() {
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("welcome to china");
            }
        };
        scheduExec.scheduleWithFixedDelay(task, 1000 * 1, 1000, TimeUnit.MILLISECONDS);
    }


    public static void main(String[] args) throws InterruptedException {
        //ScheduledExecutorServiceTest scheduledExecutorServiceTest = new ScheduledExecutorServiceTest() ;
        //scheduledExecutorServiceTest.lanuchTimer();
        //TimeUnit.SECONDS.sleep(5);
        //scheduledExecutorServiceTest.addOneTask();

        AtomicInteger value = new AtomicInteger(10);

        value.incrementAndGet() ;


        System.out.println(value.get()) ;
    }

}
