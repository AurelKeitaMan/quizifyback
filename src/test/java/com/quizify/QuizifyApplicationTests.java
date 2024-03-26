package com.quizify;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.quizify.model.Categorie;
import com.quizify.model.Question;
import com.quizify.repository.CategorieRepository;
import com.quizify.repository.QuestionRepository;
import com.quizify.repository.ReponseRepository;

@SpringBootTest
class QuizifyApplicationTests {
	
	@Autowired
	private CategorieRepository categorieRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private ReponseRepository reponseRepo;
	
	@BeforeEach
	void clean() {
		
		reponseRepo.deleteAll();
		questionRepo.deleteAll();
		categorieRepo.deleteAll();
		
		Categorie animaux = new Categorie("Animaux");
		Categorie musique = new Categorie("Musique");
		Categorie cinema = new Categorie("Cinéma");
		Categorie sport = new Categorie("Sport");

		
		categorieRepo.saveAll(Arrays.asList(animaux, musique, cinema, sport));
		
		Question serpent = new Question("Quel est le serpent qui n'est pas venimeux ?", animaux);
		Question ariana = new Question("Où est née Ariana Grande ?", musique);
	}
	
	@Test
	void contextLoads() {
	}

}
