package com.quizify.services;

import java.util.List;

import com.quizify.model.Question;

import jakarta.validation.Valid;

public interface ServiceQuestion {

	List<Question> listerQuestions();
	Question questionParId(Long questionId);
	Question ajouterQuestion(@Valid Question questionPost);
	Question modifierQuestion(@Valid Question questionUpdate, Long questionId);
	void supprimerQuestion(Long questionId);

}