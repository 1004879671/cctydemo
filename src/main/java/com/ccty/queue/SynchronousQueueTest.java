package com.ccty.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * size()  一定是0
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> sq = new SynchronousQueue<>();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("sq.take()---"+sq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        //
        System.out.println("---阻塞等待消费者消费---");
        sq.put("aaaa");
        //容量超过0就会阻塞住
        sq.put("bbbb");
        System.out.println(sq.size());

    }


}
