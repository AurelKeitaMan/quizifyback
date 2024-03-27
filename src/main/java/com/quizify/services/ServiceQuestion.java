package com.quizify.services;

import java.util.List;

import com.quizify.model.Question;
import com.quizify.services.dto.QuestionDTO;

import jakarta.validation.Valid;

public interface ServiceQuestion {

	List<QuestionDTO> listerQuestions();
	List<QuestionDTO> listerQuestionsParCategorie(long catagorieId);
	Question questionParId(Long questionId);
	Question ajouterQuestion(@Valid Question questionPost);
	Question modifierQuestion(@Valid Question questionUpdate, Long questionId);
	void supprimerQuestion(Long questionId);

}