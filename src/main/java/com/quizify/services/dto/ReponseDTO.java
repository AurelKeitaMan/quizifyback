package com.quizify.services.dto;

import lombok.Data;


@Data
public class ReponseDTO {
	
	private Long id;
	
	private String libelle;
	
	private Boolean estCorrect;
	
}
