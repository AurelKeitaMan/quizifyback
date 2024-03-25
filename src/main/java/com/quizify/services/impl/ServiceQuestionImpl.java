package com.quizify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizify.model.Categorie;
import com.quizify.model.Question;
import com.quizify.repository.CategorieRepository;
import com.quizify.repository.QuestionRepository;
import com.quizify.services.ServiceQuestion;
import com.quizify.services.dto.CategorieDTO;
import com.quizify.services.dto.QuestionDTO;

@Service
public class ServiceQuestionImpl implements ServiceQuestion {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<QuestionDTO> listerQuestions() {
		List<Question> questions = questionRepository.findAll();
		List<QuestionDTO> listDto = questions.stream().map(p -> modelMapper.map(p, QuestionDTO.class))
				.collect(Collectors.toList());
		return listDto;
	}
	

	@Override
	public List<QuestionDTO> listerQuestionParCategorie(long categorieId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<QuestionDTO> listerQuestionParCategorie(long categorieId) {
//		Categorie categorie = categorieRepository.findById(categorieId).orElseThrow();
//		List<Question> salaries = questionRepository.findByPole(categorie);
//		List<QuestionDTO> listDto = salaries.stream().map(p -> modelMapper.map(p, QuestionDTO.class))
//				.collect(Collectors.toList());
//		return listDto;
//	}

	@Override
	public List<CategorieDTO> listerPoles() {
		List<Categorie> poles = categorieRepository.findAll();
		List<CategorieDTO> listDto = poles.stream().map(s -> modelMapper.map(s, CategorieDTO.class)).collect(Collectors.toList());
		return listDto;
	}
}
