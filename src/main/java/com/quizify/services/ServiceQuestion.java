package com.quizify.services;

import java.util.List;

import com.quizify.services.dto.QuestionDTO;
import com.quizify.services.dto.QuestionFrontDTO;

import jakarta.validation.Valid;

public interface ServiceQuestion {

	List<QuestionDTO> listerQuestions();
	List<QuestionDTO> listerQuestionsParCategorie(long catagorieId);
    List<QuestionDTO> getRandomQuestionsByCategory(Long categoryId);
	QuestionDTO questionParId(Long questionId);
	QuestionDTO ajouterQuestion(@Valid QuestionDTO questionPost);
	QuestionFrontDTO ajouterQuestionFrontDTO(@Valid QuestionFrontDTO questionPost,long categorieId);
	QuestionDTO modifierQuestion(@Valid QuestionDTO questionUpdate, Long questionId);
	void supprimerQuestion(Long questionId);

}