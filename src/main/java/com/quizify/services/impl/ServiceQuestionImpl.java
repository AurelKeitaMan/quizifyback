package com.quizify.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Question;
import com.quizify.repository.QuestionRepository;
import com.quizify.services.ServiceQuestion;
import jakarta.validation.Valid;

@Service
public class ServiceQuestionImpl implements ServiceQuestion {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> listerQuestions() {
		List<Question> questions = questionRepository.findAll();
		return questions;
	}

	@Override
	public Question ajouterQuestion(@Valid Question questionPost) {
		return questionRepository.save(questionPost);
	}

	@Override
	public void supprimerQuestion(Long questionId) {
		questionRepository.deleteById(questionId);
	}

	@Override
	public Question questionParId(Long questionId) {
		return questionRepository.findById(questionId).orElseThrow();
	}

	@Override
	public Question modifierQuestion(@Valid Question questionUpdate, Long questionId) {
		Question question = questionRepository.findById(questionId).orElseThrow();
		question.setLibelle(questionUpdate.getLibelle());
		return questionRepository.save(question);
	}
}
