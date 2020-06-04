package edu.xpu.hcp.bean.definition;

import edu.xpu.hcp.entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-definition-context.xml");
        User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user1");
        System.out.println(user1==user);
    }
}
