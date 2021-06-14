package com.spring.basic.quiz;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {
	
	//@Autowired
	private Monitor monitor;
	//@Autowired
	private Keyboard keyboard;
	//@Autowired
	private Mouse mouse;
	
	@Autowired
	public Computer(Monitor monitor, Keyboard keyboard, Mouse mouse) {
		super();
		this.monitor = monitor;
		this.keyboard = keyboard;
		this.mouse = mouse;
	}

	public void computerInfo() {
		System.out.println("*** 컴퓨터 정보 ***");
		monitor.info();
		keyboard.info();
		mouse.info();
	}
}
