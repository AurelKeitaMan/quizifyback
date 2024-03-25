package com.quizify.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Categorie;
import com.quizify.repository.CategorieRepository;
import com.quizify.services.ServiceCategorie;

@Service
public class ServiceCategorieImpl implements ServiceCategorie {
	
	@Autowired
	private CategorieRepository categorieRepository;

	
	@Override
	public List<Categorie> listerLesCategories (){
		List<Categorie> categorie = categorieRepository.findAll();
		return categorie;
	}
	
	@Override
	public Categorie retrouverCategorieParId (Long categorieId) {
		return categorieRepository.findById(categorieId).orElseThrow();
	}
	
	@Override
	public Categorie ajouterCategorie (Categorie categoriePost) {
		return categorieRepository.save(categoriePost);
	}
	
	@Override
	public Categorie modifierCategorie (Categorie categorieUpdate) {
		return categorieRepository.save(categorieUpdate);
	}
	
	@Override
	public void supprimerCategorie (Long categorieId) {
		categorieRepository.deleteById(categorieId);
	}
	

}
