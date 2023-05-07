package com.ccty.threadLoadDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *ConcurrentHashMap的put操作是原子性的，但是get操作不是原子性的，可能会返回一个过期的值
 */
public class Demo2 {

    public static void main(String[] args) {


        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        new Thread(()->{
            map.put("key", 1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put("key", 2);
            System.out.println("---2----"+map.get("key"));
        }).start();
        map.put("key", 0);
        System.out.println(map.get("key"));


        Map<String, Integer> hashMap = new ConcurrentHashMap<>();
        new Thread(()->{
            hashMap.put("key", 1);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hashMap.put("key", 2);
            System.out.println("---3----"+hashMap.get("key"));
        }).start();
        hashMap.put("key", 0);
        System.out.println(hashMap.get("key"));



    }
}
