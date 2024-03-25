package com.quizify.services;

import java.util.List;

import com.quizify.model.Reponse;

public interface ServiceReponse {
	
	List<Reponse> getReponse();

	Reponse getReponseById(Long idReponse);

	void addReponse(Reponse reponse);

	void deleteReponse(Long idReponse);

	void updateReponse(Long idReponse, Reponse reponse);
}
