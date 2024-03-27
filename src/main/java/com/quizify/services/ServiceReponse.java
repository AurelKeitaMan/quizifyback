package com.quizify.services;

import java.util.List;

import com.quizify.model.Reponse;
import com.quizify.services.dto.ReponseDTO;

public interface ServiceReponse {
	
	List<ReponseDTO> getReponse();

	Reponse getReponseById(Long idReponse);

	Reponse addReponse(Reponse reponse);

	void deleteReponse(Long idReponse);

	Reponse updateReponse(Long idReponse, Reponse reponse);
	
	List<ReponseDTO> getReponseByQuestion(long id);
}
