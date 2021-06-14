package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	 # @Autowired
	 - 객체를 자동 주입할 때 사용하는 아노테이션입니다.
	 - 스캔명령을 통해 객체를 찾아 주입하는데 타입이름으로 검색합니다.
	 - 타입을 찾아내지 못하면 이름(id속성값)을 통해 검색합니다.
	 - 생성자, 필드, 메서드에 적용 가능합니다.
	 - 필드에 자동주입 설정을 수행할 때는 기본 생성자가 반드시 있어야 합니다. 
	
	 # @Qualifier("bean id")
	 - Autowired를 사용할 때 동일 타입의 빈이 여러 개 있을 경우
	  어떤 빈을 주입해야 하는지 선택해주는 추가 아노테이션
	
	*/
	
	@Autowired
	@Qualifier("paper1")
	private Paper paper;
	
	public Printer() {
		
	}
	
	//@Autowired
	public Printer(Paper paper) {
		this.paper = paper;
	}
	
	@Autowired
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
	public void showPaperInfo() {
		for (String info : paper.data) {
			System.out.println(info);
		}
	}
}
