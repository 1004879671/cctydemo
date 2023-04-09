package com.ccty.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 有界队列
 */
public class ArrayBlockingQueueTest {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static BlockingQueue<String> linkedBlockingDeque = new LinkedBlockingDeque<>();


    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<11;i++){
            //满了就会等待，程序阻塞
//            strs.put("a"+i);
            //满了会异常
//            strs.add("a"+i);
            //满了之后，时间超时会跳过
            strs.offer("a"+i,1,TimeUnit.SECONDS);


        }
        boolean b = strs.offer("aaaa",1, TimeUnit.SECONDS);


        System.out.println(b);
        System.out.println("---1---"+strs);

        System.out.println(strs.peek());
        System.out.println("---2---"+strs);

        System.out.println(strs.poll());
        System.out.println("---3---"+strs);

        System.out.println(strs.take());
        System.out.println("---4---"+strs);
        for (String s:strs){
            System.out.println(strs.take());
        }
        System.out.println("strs.peek()--不会阻塞，取完之后容量不变-"+strs.peek());
        System.out.println("strs.poll()--不会阻塞，取完之后容量减1-"+strs.poll());
        System.out.println("strs.take()--会阻塞-"+strs.take());




        for (int i=0;i<11;i++){
            linkedBlockingDeque.put("b"+i);
//            strs.add("a"+i);
        }

        for (String s:linkedBlockingDeque){
            System.out.println(linkedBlockingDeque.take());
        }

        boolean b0 = linkedBlockingDeque.offer("b0",1, TimeUnit.SECONDS);
        System.out.println(b0);
        System.out.println("---1---"+linkedBlockingDeque);

        System.out.println(linkedBlockingDeque.peek());
        System.out.println("---2---"+linkedBlockingDeque);

        System.out.println(linkedBlockingDeque.poll());
        System.out.println("---3---"+linkedBlockingDeque);

        System.out.println(linkedBlockingDeque.take());
        System.out.println("---4---"+linkedBlockingDeque);






    }



}
