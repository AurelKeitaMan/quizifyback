package com.quizify.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.model.Categorie;
import com.quizify.repository.CategorieRepository;
import com.quizify.services.ServiceCategorie;

import jakarta.validation.Valid;

@Service
public class ServiceCategorieImpl implements ServiceCategorie {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Categorie> listerLesCategories(){
		List<Categorie> categorie = categorieRepository.findAll();
		return categorie;
	}
	
	@Override
	public Categorie retrouverCategorieParId (Long categorieId) {
		return categorieRepository.findById(categorieId).orElseThrow();
	}

	@Override
	public Categorie ajouterCategorie(@Valid Categorie categoriePost) {
		categorieRepository.save(categoriePost);
		return null;
	}

	@Override
	public Categorie modifierCategorie(@Valid Categorie categorieUpdate, Long categorieId) {
		Categorie categorie = categorieRepository.findById(categorieId).orElseThrow();
		categorie.setLibelle(categorieUpdate.getLibelle());
		return categorieRepository.save(categorie);
	}

	@Override
	public void supprimerCategorie(Long categorieId) {
		categorieRepository.deleteById(categorieId);
		
	}
	
	

}
