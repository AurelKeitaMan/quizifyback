package com.quizify.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Reponse;
import com.quizify.repository.ReponseRepository;
import com.quizify.services.ServiceReponse;
import com.quizify.services.dto.ReponseDTO;

@Service
public class ServiceReponseImpl implements ServiceReponse{
	
	@Autowired
	private ReponseRepository reponseRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ReponseDTO> getReponse() {
		List<Reponse> r = reponseRepo.findAll();
		return r.stream().map(q -> modelMapper
				.map(q, ReponseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Reponse getReponseById(Long idReponse) {
		return reponseRepo.findById(idReponse).orElseThrow();
	}

	@Override
	public Reponse addReponse(Reponse reponse) {
	return reponseRepo.save(reponse);
	}

	@Override
	public void deleteReponse(Long idReponse) {
		Reponse reponse = reponseRepo.findById(idReponse).orElseThrow();
		reponseRepo.delete(reponse);
	}

	@Override
	public Reponse updateReponse(Long idReponse, Reponse newReponse) {
			newReponse.setId(idReponse);
			return reponseRepo.save(newReponse);
	}
	
	@Override
	public List<ReponseDTO> getReponseByQuestion(long id) {
		List<Reponse> r = reponseRepo.findByQuestionId(id);
		return r.stream().map(q -> modelMapper
				.map(q, ReponseDTO.class)).collect(Collectors.toList());
	}

}
