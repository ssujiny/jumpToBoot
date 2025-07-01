package com.mysite.sbb.question;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	// findBySubject() 메서드는 기본 제공 X -> 인터페이스에 추가 필요
	// JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능 있음
	// ex) findBy + 엔티티 속성명 -> 속성명으로 데이터 조회 가능하다!
	Question findBySubject(String subject);
	
	// 2개의 엔티티 속성명 조회하려먼 And 연산자 사용
	Question findBySubjectAndContent(String subject, String content);
	
	List<Question> findBySubjectLike(String subject);
	
	// 페이징 기능 추가
	Page<Question> findAll(Pageable pageable);
	
	// lazy loading 개선
	@Query("SELECT q FROM Question q LEFT JOIN FETCH q.voter WHERE q.id = :id")
	Optional<Question> findByIdWithVoter(@Param("id") Integer id);
	
}
