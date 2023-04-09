package com.ccty.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingDeque;

public class ConcurrentSkipListMapTest {

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentSkipListMap<>();
        map.put("b","1");
        map.put("c","2");
        map.put("a","3");
        System.out.println(map);

        Queue<String> queue = new LinkedBlockingDeque<>();
        String str = queue.poll();
        System.out.println(str);

        List<String> lt =new ArrayList<>();
        String str1 = lt.remove(0);
        System.out.println(lt);

    }
}
