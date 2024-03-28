package com.quizify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Question;
import com.quizify.model.Reponse;
import com.quizify.repository.QuestionRepository;
import com.quizify.repository.ReponseRepository;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.ServiceReponse;
import com.quizify.services.dto.QuestionDTO;
import com.quizify.services.dto.ReponseDTO;

import jakarta.validation.Valid;

@Service
public class ServiceQuestionImpl implements ServiceQuestion {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ServiceReponse sr;
	@Autowired
	private ReponseRepository reponseRepo;

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
	public QuestionDTO ajouterQuestion(@Valid QuestionDTO questionPost) {
		Question q = modelMapper.map(questionPost, Question.class);
		questionRepository.save(q);
		for(ReponseDTO dto : questionPost.getReponse()) {
			Reponse r = modelMapper.map(dto, Reponse.class);
			r.setQuestion(q);
			reponseRepo.save(r);
		}
		QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
		dto.setReponse(sr.getReponseByQuestion(q.getId()));
		return dto;
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
	public QuestionDTO modifierQuestion(@Valid QuestionDTO questionUpdate, Long questionId) {
		Question question = questionRepository.findById(questionId).orElseThrow();
		
		question.setId(questionId);
		question.setLibelle(questionUpdate.getLibelle());
		question.setCategorie(questionUpdate.getCategorie());
		
		for(ReponseDTO dto : questionUpdate.getReponse()) {
			Reponse r = modelMapper.map(dto, Reponse.class);
			r.setQuestion(question);
			reponseRepo.save(r);
		}
		questionRepository.save(question);
		return questionUpdate;
	}
}
