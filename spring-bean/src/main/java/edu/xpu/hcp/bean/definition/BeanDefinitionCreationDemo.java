package edu.xpu.hcp.bean.definition;

import edu.xpu.hcp.entity.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition } 构建示例
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder 构建
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        definitionBuilder.addPropertyValue("name","张三");
        definitionBuilder.addPropertyValue("age",25);
        //获取BeanDefinition实例
        AbstractBeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
        //beanDefinition并非最终状态，我们还可以进行补充操作


        //2、通过AbstractBeanDefinition以及派生类构建
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues values = new MutablePropertyValues();
        values.addPropertyValue("name","李四");
        values.addPropertyValue("age",21);
        genericBeanDefinition.setPropertyValues(values);

    }
}
