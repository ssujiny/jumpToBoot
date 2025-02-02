package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq_gen")
    @SequenceGenerator(name = "answer_seq_gen", sequenceName = "answer_seq", allocationSize = 1)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(length = 1000)
	private String content;
	
	private LocalDateTime createDate;
	
	//답변-질문은 N:1 관계
	@ManyToOne
	private Question question;
	
}
