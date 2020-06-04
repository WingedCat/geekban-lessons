package edu.xpu.hcp.bean.creation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 特殊的Bean实例化示例
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:special-bean-creation-context.xml");
        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        DefaultUserFactory bean = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
        System.out.println(bean.createUser());
    }

    private static void byServiceLoader(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:special-bean-creation-context.xml");
        demoServiceLoader();
        System.out.println("================");
        ServiceLoader<UserFactory> loader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(loader);
    }


    public static void demoServiceLoader(){
        ServiceLoader<UserFactory> loader = ServiceLoader.load(UserFactory.class,Thread.currentThread().getContextClassLoader());
        displayServiceLoader(loader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> loader){
        Iterator<UserFactory> iterator = loader.iterator();
        while (iterator.hasNext()){
            UserFactory next = iterator.next();
            System.out.println(next);
            System.out.println(next.createUser());
        }
    }
}
