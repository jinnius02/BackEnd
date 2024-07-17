package com.ureca.step4.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
//		MessageBeanImpl msg = new MessageBeanImpl();
//		msg.sayHello();
		
		ApplicationContext ctx= 
	       new ClassPathXmlApplicationContext("com/ureca/step4/di/applicationContext.xml");
//		MessageBean msg = ctx.getBean("msgBean", MessageBean.class);
		MessageBean msg = ctx.getBean(MessageBean.class);
		   msg.sayHello();
	}

}