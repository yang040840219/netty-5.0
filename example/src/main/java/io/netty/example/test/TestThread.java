package io.netty.example.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangxiaolong on 2015/3/5.
 */
public class TestThread implements Runnable {

    private int i = 0 ;

    TestThread(int i){
        this.i = i ;
    }


    @Override
    public void run() {
            System.out.println("TestThread ....." + this.i) ;
           while(true){

           }
}

    public static void main(String[] args){
        TestThread t1 = new TestThread(1);
        TestThread t2 = new TestThread(2);
        TestThread t3 = new TestThread(3);
//        Thread  thread = new Thread(t) ;
//        thread.start();


//        ExecutorService executorService = Executors.newFixedThreadPool(3) ;
//
//        executorService.execute(t1);
//
//        executorService.execute(t2);
//
//        executorService.execute(t3);

        //executorService.shutdown();

    }
}



