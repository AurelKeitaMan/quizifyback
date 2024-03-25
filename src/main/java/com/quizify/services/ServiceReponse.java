package com.quizify.services;

import java.util.List;

import com.quizify.model.Reponse;

public interface ServiceReponse {
	
	List<Reponse> getReponse();

	Reponse getReponseById(Long idReponse);

	Reponse addReponse(Reponse reponse);

	void deleteReponse(Long idReponse);

	Reponse updateReponse(Long idReponse, Reponse reponse);
}
