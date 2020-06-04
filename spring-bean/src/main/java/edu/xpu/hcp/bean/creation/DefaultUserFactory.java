package edu.xpu.hcp.bean.creation;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    //1、基于@PostConstruct

    @PostConstruct
    public void init(){
        System.out.println("init...");
    }

    public void otherInit(){
        System.out.println("otherInit");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy...");
    }

    public void myDestroy(){
        System.out.println("myDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("DefalutUserFactory finalize.....");
    }
}
