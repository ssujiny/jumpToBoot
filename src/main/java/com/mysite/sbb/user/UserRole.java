package com.mysite.sbb.user;

import lombok.Getter;

// enum(열거 자료형) : 상수는 값 변경할 필요 X -> setter없이 getter만 사용
@Getter
public enum UserRole {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	UserRole(String value) {
		this.value = value;
	}
	
	private String value;
}
