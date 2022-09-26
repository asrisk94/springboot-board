package com.mysite.sbb.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionDto {

	/*
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
	*/
	
	private Integer id;
	private String subject;
	private String content;
	private LocalDateTime createDate;
	private List<Answer> answerList;
	
	@Builder
	public QuestionDto(Integer id, String subject, String content, LocalDateTime createDate, List<Answer> answerList) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.createDate = createDate;
		this.answerList = answerList;
	}
	
	public Question toEntity() {
		return Question.builder().id(id).subject(subject).content(content).createDate(createDate).answerList(answerList).build();
	}
}
