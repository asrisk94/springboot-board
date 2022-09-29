package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.dto.QuestionDto;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class QuestionService {

	private final QuestionRepository questionRepository;
	
	public List<QuestionDto> getList() {
		
		List<Question> questionList =	this.questionRepository.findAll();
		List<QuestionDto> questionDtoList = new ArrayList<>();
		
		QuestionConverter qc = new QuestionConverter();
		
		
		for(int i=0; i < questionList.size(); i++) {
			questionDtoList.add( qc.questionToDto(questionList.get(i)) );
			
		}
		
		return questionDtoList;
	}
	
	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if(question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
		
	public void create(String subject, String content) {
		Question q = new Question();
		q.setSubject(subject);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q);
	}
		
}
