package com.mysite.sbb.question;

import com.mysite.sbb.dto.QuestionDto;

public class QuestionConverter {

	public QuestionDto questionToDto(Question question) {
		QuestionDto qd = new QuestionDto(
				question.getId(), 
				question.getSubject(), 
				question.getContent(), 
				question.getCreateDate(), 
				question.getAnswerList());
		
		return qd;
	}
}
