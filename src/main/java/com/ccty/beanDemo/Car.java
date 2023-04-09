package com.ccty.beanDemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *  Bean 构造函数 ——> @PostConstruct ——> InitializingBean 接口 ——> bean 定义的 init-method——>
 *  postProcessBeforeInitialization ——> Bean 初始化完成 ——> postProcessAfterInitialization ——> 容器创建完成
 *  --> @PreDestroy --> DisposableBean --> destory-method
 */
public  class Car implements InitializingBean, DisposableBean, BeanPostProcessor {
     public Car() {
      System.out.println("Car 创建");
     }

     public void initTest() {
      System.out.println(" .. init-method .. ");
     }

     public void detoryTest() {
      System.out.println(" .. destory-method .. ");
     }

     @Override
     public void afterPropertiesSet() throws Exception {
      System.out.println(" .. InitializingBean .. ");
     }

     @Override
     public void destroy() throws Exception {
      System.out.println(" .. DisposableBean .. ");
     }

     @Override
     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println(" .. postProcessBeforeInitialization .. ");
      return bean;
     }

     @Override
     public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println(" .. postProcessAfterInitialization .. ");
      return bean;
     }

     @PostConstruct
     public void postConstructTest() {
      System.out.println(" .. @PostConstruct .. ");
     }

     @PreDestroy
     public void preDestroyTest() {
      System.out.println(" .. @PreDestroy .. ");
     }
}
