package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.dto.QuestionDto;

import lombok.RequiredArgsConstructor;

// 클래스 상단 @RequestMapping -> URL prefix
@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

	// private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		
		List<QuestionDto> questionList = questionService.getList();
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "question_detail";
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
