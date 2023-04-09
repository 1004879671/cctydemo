package com.ccty.beanDemo;

import com.ccty.beanDemo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController implements InitializingBean, DisposableBean, BeanPostProcessor {
//    @Autowired
//    Car car;

    private Map<String,String> map = new ConcurrentHashMap<>();

    @GetMapping("/A")
    public Map getA() {

//        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(TestController.class);
//        c.close();

        return map;
    }

    @GetMapping("/B")
    public Map getB() {
        map.put("1","asdasd");
        map.put("2","asdasdfsfsd");
        map.put("3","asdasdfsd");


        return map;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("---destroy----");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---afterPropertiesSet----");

    }
}
