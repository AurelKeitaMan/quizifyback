package com.quizify.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.quizify.model.Reponse;
import com.quizify.repository.ReponseRepository;
import com.quizify.services.ServiceReponse;


public class ServiceReponseImpl implements ServiceReponse{
	
	@Autowired
	private ReponseRepository reponseRepo;

	@Override
	public List<Reponse> getReponse() {
		return reponseRepo.findAll();
	}

	@Override
	public Reponse getReponseById(Long idReponse) {
		return reponseRepo.findById(idReponse).orElseThrow();
	}

	@Override
	public void addReponse(Reponse reponse) {
	reponseRepo.save(reponse);
	}

	@Override
	public void deleteReponse(Long idReponse) {
		Reponse reponse = reponseRepo.findById(idReponse).orElseThrow();
		reponseRepo.delete(reponse);
	}

	@Override
	public void updateReponse(Long idReponse, Reponse newReponse) {
			newReponse.setId(idReponse);
			reponseRepo.save(newReponse);
	}

}
