package edu.xpu.hcp.bean.destroy;

import edu.xpu.hcp.bean.creation.DefaultUserFactory;
import edu.xpu.hcp.bean.creation.UserFactory;
import edu.xpu.hcp.bean.initial.BeanInitializationDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanDestroyDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanDestroyDemo.class);
        context.refresh();
        UserFactory bean = context.getBean(UserFactory.class);
        System.out.println("spring应用上下文准备关闭");
        context.close();
        System.out.println("spring应用上下文已关闭");
    }

    @Bean(destroyMethod = "myDestroy")
    public DefaultUserFactory defaultUserFactory(){
        return new DefaultUserFactory();
    }
}
