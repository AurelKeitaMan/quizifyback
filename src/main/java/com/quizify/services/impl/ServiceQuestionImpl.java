package com.quizify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Question;
import com.quizify.model.Reponse;
import com.quizify.repository.CategorieRepository;
import com.quizify.repository.QuestionRepository;
import com.quizify.repository.ReponseRepository;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.ServiceReponse;
import com.quizify.services.dto.QuestionDTO;
import com.quizify.services.dto.QuestionFrontDTO;
import com.quizify.services.dto.ReponseDTO;

import jakarta.transaction.Transactional;
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

	@Autowired
	private CategorieRepository catRepo;

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
		for (ReponseDTO dto : questionPost.getReponse()) {
			Reponse r = modelMapper.map(dto, Reponse.class);
			r.setQuestion(q);
			reponseRepo.save(r);
		}
		QuestionDTO dto = modelMapper.map(q, QuestionDTO.class);
		dto.setReponse(sr.getReponseByQuestion(q.getId()));
		return dto;
	}

	@Override
	public QuestionFrontDTO ajouterQuestionFrontDTO(QuestionFrontDTO dto, long categorieId) {
		Question q = new Question();
		Reponse r = new Reponse();
		Reponse r2 = new Reponse();
		Reponse r3 = new Reponse();
		Reponse r4 = new Reponse();

		q.setCategorie(catRepo.findById(categorieId).orElseThrow());
		q.setLibelle(dto.getLibelle());
		questionRepository.save(q);

		r.setLibelle(dto.getReponse1());

		if ("reponse1".equals(dto.getBonneReponse())) {
			r.setEstCorrect(true);
		} else {
			r.setEstCorrect(false);
		}
		
		r.setQuestion(q);
		reponseRepo.save(r);

		r2.setLibelle(dto.getReponse2());

		if ("reponse2".equals(dto.getBonneReponse())) {
			r2.setEstCorrect(true);
		} else {
			r2.setEstCorrect(false);
		}
		r2.setQuestion(q);
		reponseRepo.save(r2);

		r3.setLibelle(dto.getReponse3());

		if ("reponse3".equals(dto.getBonneReponse())) {
			r3.setEstCorrect(true);
		} else {
			r3.setEstCorrect(false);
		}
		r3.setQuestion(q);
		reponseRepo.save(r3);

		r4.setLibelle(dto.getReponse4());

		if ("reponse4".equals(dto.getBonneReponse())) {
			r4.setEstCorrect(true);
		} else {
			r4.setEstCorrect(false);
		}
		r4.setQuestion(q);
		reponseRepo.save(r4);

		return dto;
	}

	@Override
	@Transactional
	public void supprimerQuestion(Long questionId) {
		List<Reponse> reponses = reponseRepo.findByQuestionId(questionId);
		for (Reponse reponse : reponses) {
			reponseRepo.deleteById(reponse.getId());
		}
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

		for (ReponseDTO dto : questionUpdate.getReponse()) {
			Reponse r = modelMapper.map(dto, Reponse.class);
			r.setQuestion(question);
			reponseRepo.save(r);
		}
		questionRepository.save(question);
		return questionUpdate;
	}

}
