package com.springboot.studybosung.web.controller.api.di;

import org.springframework.stereotype.Component;

@Component("t2")
public class TestInterfaceImpl2 implements TestInterface{

	@Override
	public void a() {
		System.out.println("테스트 인터페이스 2에서 호출한 a메소드");
	}

	@Override
	public void b() {
		System.out.println("테스트 인터페이스 2에서 호출한 b메소드");
		
	}

}
