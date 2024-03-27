package com.quizify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.quizify.model.Question;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.dto.QuestionDTO;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/question")
@Log4j2
@CrossOrigin(origins = "http://localhost:4200/")
public class QuestionController {
	
	@Autowired
	private ServiceQuestion serviceQuestion;
	
	@GetMapping
	public List<QuestionDTO> getAll() {
		return serviceQuestion.listerQuestions();
	}
	
	@GetMapping("/random/{categorieId}")
	public List<QuestionDTO> getThreeQuestions(@PathVariable Long categorieId) {
		return serviceQuestion.getRandomQuestionsByCategory(categorieId);
	}
	
	@GetMapping("{categorieId}/categorie")
	public List<QuestionDTO> getByCategory(@PathVariable Long categorieId) {
		return serviceQuestion.listerQuestionsParCategorie(categorieId);
	}
	
	@GetMapping("{questionId}")
	public QuestionDTO getQuestionById(@PathVariable Long questionId) {
		return serviceQuestion.questionParId(questionId);
	}
	
	@PostMapping
	public Question ajouterQuestion(@RequestBody @Valid Question questionPost) {
		log.info("Question ajoutée : " + questionPost);
		return serviceQuestion.ajouterQuestion(questionPost);
	}
	
	@PutMapping("{questionId}")
	public Question modifierQuestion(@RequestBody @Valid Question questionUpdate, @PathVariable Long questionId) {
		return serviceQuestion.modifierQuestion(questionUpdate, questionId);
	}
	
	@DeleteMapping("{questionId}")
	public void supprimerCategorieParId(@PathVariable Long questionId) {
		if(serviceQuestion.questionParId(questionId) == null) {
			throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
		}else {
			serviceQuestion.supprimerQuestion(questionId);
		}
	}
	}
