package com.quizify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.dto.QuestionDTO;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	private ServiceQuestion serviceQuestion;
	
	@GetMapping
	public List<QuestionDTO> getAll() {
		return serviceQuestion.listerQuestions();
	}
	
	@GetMapping("/categorie/{id}")
	public List<QuestionDTO> getAllByPole(@PathVariable long id) {
		return serviceQuestion.listerQuestionParCategorie(id);
	}
}
