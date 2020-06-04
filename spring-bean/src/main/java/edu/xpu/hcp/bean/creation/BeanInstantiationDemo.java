package edu.xpu.hcp.bean.creation;

import edu.xpu.hcp.entity.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:bean-creation-context.xml");
        User bean = beanFactory.getBean("user-by-static-method", User.class);
        User bean1 = beanFactory.getBean("user-by-factory", User.class);
        User bean2 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);

    }
}
