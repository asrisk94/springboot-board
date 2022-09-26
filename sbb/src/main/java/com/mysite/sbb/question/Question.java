package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.dto.QuestionDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Question {
	
	public Question() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList; 
	
	@Builder
	public Question(Integer id, String subject, String content, LocalDateTime createDate, List<Answer> answerList) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.createDate = createDate;
		this.answerList = answerList;
	}
}




