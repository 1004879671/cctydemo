package com.ccty.threadLoadDemo;

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
        new Thread(){
            @Override
            public void run() {
                System.out.println(x.get());
            }
        }.start();

//        x.set(10l);
//        x.remove();
        System.out.println(x.get());
    }
}
