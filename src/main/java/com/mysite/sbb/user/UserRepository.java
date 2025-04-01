package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
	Optional<SiteUser> findByUsername(String username);
	
	/* Optional 클래스
	 * 값이 없는 경우를 표현하기 위한 클래스 -> NPE(NullPointException) 방지하기 위해 사용
	 * null이 올 수 있는 값을 감싸는 Wrapper 클래스로 참조하더라도 NPE 발생 X
	 * ex) Spring Data JPA를 사용할 때 Repository에서 findById()의 반환값은 Optional 타입
	 */
}
