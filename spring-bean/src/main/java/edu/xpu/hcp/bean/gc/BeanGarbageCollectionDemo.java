package edu.xpu.hcp.bean.gc;

import edu.xpu.hcp.bean.creation.DefaultUserFactory;
import edu.xpu.hcp.bean.creation.UserFactory;
import edu.xpu.hcp.bean.destroy.BeanDestroyDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Bean垃圾回收示例
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanGarbageCollectionDemo.class);
        context.refresh();
        context.close();
        //强制GC
        System.gc();
    }

    @Bean
    public DefaultUserFactory defaultUserFactory(){
        return new DefaultUserFactory();
    }
}
