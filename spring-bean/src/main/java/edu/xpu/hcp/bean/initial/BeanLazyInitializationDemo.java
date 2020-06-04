package edu.xpu.hcp.bean.initial;

import edu.xpu.hcp.bean.creation.DefaultUserFactory;
import edu.xpu.hcp.bean.creation.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanLazyInitializationDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanLazyInitializationDemo.class);
        context.refresh();
        //非延迟初始化在Spring应用上下文启动完成后被初始化
        System.out.println("Spring 应用上下文已启动...");
        UserFactory bean = context.getBean(UserFactory.class);
        System.out.println(bean);
        context.close();
    }

    @Bean(initMethod = "otherInit")
    @Lazy
    public DefaultUserFactory defaultUserFactory(){
        return new DefaultUserFactory();
    }
}
