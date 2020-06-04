package edu.xpu.hcp.bean.initial;

import edu.xpu.hcp.bean.creation.DefaultUserFactory;
import edu.xpu.hcp.bean.creation.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanInitializationDemo.class);
        context.refresh();
        UserFactory bean = context.getBean(UserFactory.class);
        context.close();
    }

    @Bean(initMethod = "otherInit")
    public DefaultUserFactory defaultUserFactory(){
        return new DefaultUserFactory();
    }
}
