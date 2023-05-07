package com.ccty.threadTest;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 启动线程的几种方式
 */
public class ThreadPoolTest {
    static  class MyThread1 extends Thread{
        @Override
        public void run() {
            System.out.println("Hello Mythread1");
        }
    }

    static  class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello Mythread2");
        }
    }
    //启动线程的4中方式
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        new MyThread1().start();

        new Thread(new MyThread2()).start();

        new Thread(() ->{
            System.out.println("Run 逻辑");
        }).start();


        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10,20,5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),Executors.defaultThreadFactory() ,new ThreadPoolExecutor.CallerRunsPolicy() );
        tpe.execute(new MyThread2());
        tpe.shutdown();
        // 可获取线程执行结果
        Future future = tpe.submit(new MyThread2());
        future.get();


        ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
        tpte.setCorePoolSize(10);
        tpte.setMaxPoolSize(20);
        tpte.setQueueCapacity(20);

        tpte.setKeepAliveSeconds(60);
        tpte.setThreadNamePrefix("cty-Thread-");
        // 等待所有任务结果候再关闭线程池
        tpte.setWaitForTasksToCompleteOnShutdown(true);
        tpte.setAwaitTerminationSeconds(60);

        tpte.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        tpte.initialize();

        System.out.println(Integer.valueOf("fff".hashCode()));





        // TODO AsyncThreadPoolTest();

    }

}
