package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

// 스프링부트 테스트 클래스 의미
@SpringBootTest
class SbBoardApplicationTests {
	
	/*	객체 주입 방식
	 * 1. @Autowired 이용
	 * 2. Setter 메서드/생성자 이용 (권장)
	 */
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	// 테스트 메서드 의미, SbbApplicationTests클래스 - JUnit 실행 -> @Test 붙은 메서드 실행 
	@Test
	@Transactional
	@Rollback(false) // 트랜잭션 롤백을 하지 않도록 설정
	void testJpa() {
		/*
		// 1-1. 질문 데이터 추가
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		// questionRepository.save() : question 테이블의 1번째 행에 들어갈 데이터로 위 코드 데이터 저장
		
		Question q2 = new Question();
		q2.setSubject("스프링 부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2); // 2번째 행 저장
		
		// 1-2. 질문 데이터 조회
		List<Question> all = this.questionRepository.findAll();
		// .findAll() : 모든 데이터 조회(SELECT *)
		assertEquals(2, all.size());
		// assertEquals(기댓값, 실젯값) : 예상한 결과와 실제 결과가 동일한지 확인
		
		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
		// .findById() 메서드(id값으로 데이터 조회)의 리턴타입은 Optional 클래스 : null값을 유연하게 처리하기 위한 클래스
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			// .isPresent() : 값이 존재하는지 확인
			Question q = oq.get();
			// .get() : 실제 Question 객체의 값을 얻음
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		
		// .findBySubject() : 엔티티의 subject 값으로 데이터 조회
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
		
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
		
		// 응답 결과가 여러 건일 경우 리턴타입은 List<Question> 으로 설정
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
		// 1-3. 질문 데이터 수정
		Optional<Question> oq = this.questionRepository.findById(1);
		// assertTrue() : 값이 true인지 테스트(false일 경우 오류 발생)
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
		
		// 1-4. 질문 데이터 삭제
		assertEquals(2, this.questionRepository.count());
		// 리포지터리의 .count() : 테이블 행의 개수 리턴
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		// 삭제한 후, 테이블 행 개수가 1인지 테스트
		assertEquals(1, this.questionRepository.count());
		
		// 2-1. 답변 데이터 저장
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
		
		// 2-2. 답변 데이터 조회
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
		*/
		
		// question -> answer 데이터 찾기
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
	
	
	
}

