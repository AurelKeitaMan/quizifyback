package com.quizify.services.dto;

import java.util.List;

import com.quizify.model.Categorie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {

	private Long id;
	
	private String libelle;
	
	private Categorie categorie;
	
	private List<ReponseDTO> reponse;
}
