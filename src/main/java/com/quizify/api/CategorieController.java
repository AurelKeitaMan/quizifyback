package com.quizify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.quizify.model.Categorie;
import com.quizify.services.ServiceCategorie;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/categorie")
@Log4j2
@CrossOrigin(origins = "http://localhost:4200/")
public class CategorieController {
	
	@Autowired
	private ServiceCategorie serviceCategorie;
	
	@GetMapping
	public List<Categorie> retourneToutesLesCategories(){
		return serviceCategorie.listerLesCategories();
	}
	
	@GetMapping("/q3")
	public List<Categorie> categorieWithMoreThreeQuestions(){
		return serviceCategorie.categoriesWithMoreThreeQuestions();
	}
	
	@GetMapping("{categorieId}")
	public Categorie retourneCategorieParId(@PathVariable Long categorieId) {
		return serviceCategorie.retrouverCategorieParId(categorieId);

	}
	
	@PostMapping
	public Categorie ajouterCategorie(@RequestBody @Valid Categorie categoriePost) {
		log.info("Catégorie ajoutée : " + categoriePost);
		return serviceCategorie.ajouterCategorie(categoriePost);
		
	}
	
	@PutMapping("{categorieId}")
	public Categorie modifierCategorie(@RequestBody @Valid Categorie categorieUpdate, @PathVariable Long categorieId) {
		return serviceCategorie.modifierCategorie(categorieUpdate, categorieId);
	}
	
	@DeleteMapping("{categorieId}")
	public void supprimerCategorieParId(@PathVariable Long categorieId) {
		if(serviceCategorie.retrouverCategorieParId(categorieId) == null) {
			throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
		}else {
			serviceCategorie.supprimerCategorie(categorieId);
		}
	}
}
