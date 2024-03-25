package com.quizify.services;

import java.util.List;

import com.quizify.model.Categorie;

import jakarta.validation.Valid;

public interface ServiceCategorie {
	
	List<Categorie> listerLesCategories();
	
	Categorie retrouverCategorieParId(Long categorieId);
	
	Categorie ajouterCategorie (@Valid Categorie categoriePost);
	
	Categorie modifierCategorie (@Valid Categorie categorieUpdate);
	
	void supprimerCategorie(Long categorieId);
	

}
