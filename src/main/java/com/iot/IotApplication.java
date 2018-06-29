package com.iot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


@SpringBootApplication
public class IotApplication implements ApplicationContextAware {



    private static ApplicationContext applicationContext;
    private static DefaultListableBeanFactory defaultListableBeanFactory;


    public static void main(String[] args) {
        SpringApplication.run(IotApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
    }


    public static <T> T getBean(Class<T> clazz) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        String className = clazz.getName();
        defaultListableBeanFactory.registerBeanDefinition(className, beanDefinitionBuilder.getBeanDefinition());
        return (T) applicationContext.getBean(className);
    }

    public static void destroy(String className){
        defaultListableBeanFactory.removeBeanDefinition(className);
        System.out.println("destroy " + className);
    }

}
