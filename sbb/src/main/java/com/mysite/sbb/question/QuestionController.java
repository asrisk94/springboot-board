package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.dto.QuestionDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {

	// private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@RequestMapping("/question/list")
	public String list(Model model) {
		
		List<QuestionDto> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}
	
	/*
	public String list(Model model) {
		
		// List<Question> questionList = this.questionRepository.findAll();
		List<Question> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	*/
	
}
