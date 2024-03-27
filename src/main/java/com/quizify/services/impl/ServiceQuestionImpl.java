package com.quizify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Question;
import com.quizify.repository.QuestionRepository;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.ServiceReponse;
import com.quizify.services.dto.QuestionDTO;

import jakarta.validation.Valid;

@Service
public class ServiceQuestionImpl implements ServiceQuestion {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ServiceReponse sr;

	@Override
	public List<QuestionDTO> listerQuestions() {
		List<Question> question = questionRepository.findAll();
		return question.stream().map(q -> {
			QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
			dto.setReponse(sr.getReponseByQuestion(q.getId()));
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> listerQuestionsParCategorie(long categorieId) {
		List<Question> question = questionRepository.findByCategorieId(categorieId);
		return question.stream().map(q -> {
			QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
			dto.setReponse(sr.getReponseByQuestion(q.getId()));
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public List<QuestionDTO> getRandomQuestionsByCategory(Long categoryId) {
		List<Question> questions = questionRepository.findRandomQuestionsByCategoryId(categoryId);
		return questions.stream().map(q -> {
			QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
			dto.setReponse(sr.getReponseByQuestion(q.getId()));
			return dto;
		}).collect(Collectors.toList());
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
	public QuestionDTO questionParId(Long questionId) {
		Question q = questionRepository.findById(questionId).orElseThrow();
		QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
		dto.setReponse(sr.getReponseByQuestion(q.getId()));
		return dto;
	}

	@Override
	public Question modifierQuestion(@Valid Question questionUpdate, Long questionId) {
		Question question = questionRepository.findById(questionId).orElseThrow();
		question.setLibelle(questionUpdate.getLibelle());
		return questionRepository.save(question);
	}
}
