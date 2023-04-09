package com.ccty.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class TransferQueueTest {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> tf = new LinkedTransferQueue<>();
        new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("tf.take()---"+tf.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("===============================");
        tf.tryTransfer("bbb",1, TimeUnit.SECONDS);
        System.out.println("=============1111==================");

        //线程  装完等着  阻塞
        tf.transfer("aaa");

        //装完就走
        tf.put("ccc");
        tf.put("ddd");

        System.out.println("-----transfer-----"+tf);




    }


}
