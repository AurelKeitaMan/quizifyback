package com.quizify.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Reponse;
import com.quizify.repository.ReponseRepository;
import com.quizify.services.ServiceReponse;

@Service
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

}
