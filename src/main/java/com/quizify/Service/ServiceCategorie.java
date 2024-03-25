package com.quizify.Service;

import java.util.List;

import com.quizify.Model.Categorie;

import jakarta.validation.Valid;

public interface ServiceCategorie {
	
	List<Categorie> listerLesCategories();
	
	Categorie retrouverCategorieParId(Long categorieId);
	
	Categorie ajouterCategorie (@Valid Categorie categoriePost);
	
	Categorie modifierCategorie (@Valid Categorie categorieUpdate);
	
	void supprimerCategorie(Long categorieId);
	

}
