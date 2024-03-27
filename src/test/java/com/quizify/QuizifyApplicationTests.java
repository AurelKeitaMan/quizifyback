package com.quizify;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.quizify.model.Categorie;
import com.quizify.model.Question;
import com.quizify.model.Reponse;
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
		Question laVieEstBelle = new Question("En quelle année est sorti le film “La vie est belle” ?", cinema);
		Question ballonDOr = new Question("A ce jour, qui a gagné le plus de ballons d'or ?", sport);
		
		questionRepo.saveAll(Arrays.asList(serpent, ariana, laVieEstBelle, ballonDOr));
		
		
		Reponse serpentA = new Reponse ("Le mamba noir", false, serpent);
		Reponse serpentB = new Reponse ("Le cobra Royal", false, serpent);
		Reponse serpentC = new Reponse ("La vipère", true, serpent);
		Reponse serpentD = new Reponse ("Le serpent corail", false, serpent);
		
		reponseRepo.saveAll(Arrays.asList(serpentA, serpentB, serpentC, serpentD));
		
		Reponse arianaA = new Reponse ("Aux Etats Unis", true, ariana);
		Reponse arianaB = new Reponse ("En Angleterre", false, ariana);
		Reponse arianaC = new Reponse ("En Colombie", false, ariana);
		Reponse arianaD = new Reponse ("Au Brésil", false, ariana);
		
		reponseRepo.saveAll(Arrays.asList(arianaA, arianaB, arianaC, arianaD));
		
		Reponse laVieEstBelleA = new Reponse ("1998", true, laVieEstBelle);
		Reponse laVieEstBelleB = new Reponse ("2000", false, laVieEstBelle);
		Reponse laVieEstBelleC = new Reponse ("1985", false, laVieEstBelle);
		Reponse laVieEstBelleD = new Reponse ("2010", false, laVieEstBelle);
		
		reponseRepo.saveAll(Arrays.asList(laVieEstBelleA, laVieEstBelleB, laVieEstBelleC, laVieEstBelleD));
		
		Reponse ballonDOrA = new Reponse ("Cristiano RONALDO", false, ballonDOr);
		Reponse ballonDOrB  = new Reponse ("Michel PLATINI", false, ballonDOr);
		Reponse ballonDOrC = new Reponse ("Lionel MESSI", true, ballonDOr);
		Reponse ballonDOrD = new Reponse ("Marco VAN BASTEN", false, ballonDOr);
		
		reponseRepo.saveAll(Arrays.asList(ballonDOrA, ballonDOrB, ballonDOrC, ballonDOrD));
	}

}
