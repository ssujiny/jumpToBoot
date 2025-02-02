package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor //자동 생성자 생성
@Getter
public class HelloLombok {
	// final: 불변 키워드, setter 의미X -> 사용불가
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		// final이 없다면 생성자에도 포함되지 않는다.
		/*
		 	lombok사용으로 자동생성된 생성자 모습
		  	public HelloLombok(String hello, int lombok) {
		  		this.hello = hello;
		  		this.lombok = lombok;
		  	}
		*/
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
	
}
