package edu.xpu.hcp.bean.definition;

import edu.xpu.hcp.bean.creation.DefaultUserFactory;
import edu.xpu.hcp.bean.creation.UserFactory;
import edu.xpu.hcp.bean.initial.BeanInitializationDemo;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean注册示例
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //创建外部单例对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //注册外部单例对象
        beanFactory.registerSingleton("userFactory",userFactory);
        context.refresh();
        UserFactory userFactory1 = (UserFactory) context.getBean("userFactory");
        System.out.println(userFactory1.createUser());
        System.out.println(userFactory == userFactory1);
        context.close();
    }

}
