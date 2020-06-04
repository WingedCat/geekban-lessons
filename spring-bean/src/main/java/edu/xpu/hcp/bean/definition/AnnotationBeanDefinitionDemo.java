package edu.xpu.hcp.bean.definition;

import edu.xpu.hcp.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        // 通过 BeanDefinition 注册 API 实现
        // 1.命名 Bean 的注册方式
        registerUserBeanDefinition(applicationContext, "hcp-user");
        // 2. 非命名 Bean 的注册方法
        registerBeanDefinition(applicationContext);

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    //命名 Bean 的注册方式
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry,String beanName){

        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        definitionBuilder.addPropertyValue("name","张三")
                         .addPropertyValue("age",25);
        //判断如果 BeanName 参数存在时
        if(StringUtils.hasText(beanName)){
            //注册BeanDefinition
            registry.registerBeanDefinition(beanName,definitionBuilder.getBeanDefinition());
        }else{
            //非命名的方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(definitionBuilder.getBeanDefinition(),registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry,null);
    }
    @Component
   public static class Config{

       @Bean(name = {"user","hcp"})
       public User user(){
           User user = new User();
           user.setName("huchengpeng");
           user.setAge(25);
           return user;
       }
   }
}
