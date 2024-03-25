package com.quizify.services;

import java.util.List;

import com.quizify.services.dto.CategorieDTO;
import com.quizify.services.dto.QuestionDTO;

public interface ServiceQuestion {

	List<QuestionDTO> listerQuestions();
	List<QuestionDTO> listerQuestionParCategorie(long categorieId);
	List<CategorieDTO> listerPoles();

}
