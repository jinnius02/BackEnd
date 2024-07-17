package com.ureca.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
		//applicationContext.xml 문서 읽기
		
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/ureca/step3/applicationContext.xml");		
		
		//ctrl+shift+o  ==> 전체 클래스에 대한 import 추가
		
    	//XML문서에 정의된 Bean 가져오기 ==> ctx.getBean("정의된 id명");		
//		MessageBean msg = (MessageBean) ctx.getBean("msgBean");
//		MessageBean msg =  ctx.getBean("msgBean",MessageBean.class);
		MessageBean msg =  ctx.getBean(MessageBean.class);
		
		msg.sayHello("레인");

	}

}