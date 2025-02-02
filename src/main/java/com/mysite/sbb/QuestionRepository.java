package com.mysite.sbb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	// findBySubject() 메서드는 기본 제공 X -> 인터페이스에 추가 필요
	// JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능 있음
	// ex) findBy + 엔티티 속성명 -> 속성명으로 데이터 조회 가능하다!
	Question findBySubject(String subject);
	
	// 2개의 엔티티 속성명 조회하려먼 And 연산자 사용
	Question findBySubjectAndContent(String subject, String content);
	
	List<Question> findBySubjectLike(String subject);
}
