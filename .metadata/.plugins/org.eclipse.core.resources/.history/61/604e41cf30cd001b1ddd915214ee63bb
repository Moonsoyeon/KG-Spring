package com.spring.basic.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		//퀴즈입니다
		//1. quiz-config.xml에 Monitor, Mouse, Keyboard, Computer 빈을 생성후,
		//2. Computer 클래스에서 자동 주입을 설정하세요
		//3. xml에서 빈을 얻은 후 computerInfo() 메서드를 실행하세요
		
		GenericXmlApplicationContext ct = new GenericXmlApplicationContext("classpath:quiz-config.xml");
		
		Computer com = ct.getBean("computer", Computer.class);
		com.computerInfo();
		
		ct.close();

	}

}
