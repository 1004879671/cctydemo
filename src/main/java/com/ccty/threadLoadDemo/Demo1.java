package com.ccty.threadLoadDemo;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 同一个局部变量，不同的线程访问  访问的是不同的实例
 * apt install apache2-util
 * ab -n 10000 -c 100 localhost:8080/add
 * curl localhost:8080/stat
 */
public class Demo1 {
    private static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("run init...");
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {
//        new Thread(){
//            @Override
//            public void run() {
//                System.out.println(x.get());
//            }
//        }.start();

//        x.set(10l);
//        x.remove();
//        System.out.println(x.get());

//        SoftReference softReference = new SoftReference(new String("bbbbb"));
//        WeakReference weakReference = new WeakReference(new String("aaaa"));


        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);



//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> entry = iterator.next();
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//            map.put("four", 4); // 在迭代期间修改Map
//        }
        //弱一致性 其他线程可能会对Map进行修改，因此迭代器不会反映最新的状态。
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
            map.put("four", 4); // 在迭代期间修改Map
        }

        //
        System.out.println("=================================");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        for(Map.Entry<String,Integer> entry1:hashMap.entrySet()){
            System.out.println(entry1.getKey() + " : " + entry1.getValue());
            // 会抛异常ConcurrentModificationException
            hashMap.put("four", 4); // 在迭代期间修改Map
        }


    }
}
