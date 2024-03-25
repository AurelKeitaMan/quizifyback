package com.quizify;

import org.junit.jupiter.api.Test;
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
	private CategorieRepository cr;
	@Autowired
	private QuestionRepository qr;
	@Autowired
	private ReponseRepository rr;
	
	@Test
	void contextLoads() {
		
		rr.deleteAll();
		qr.deleteAll();
		cr.deleteAll();
		
		Categorie c = new Categorie("sexe");
		cr.save(c);
		Question q = new Question("Combien je dois mettre de piles dans mon sextoy ?",c);
		qr.save(q);
		Reponse r1 = new Reponse("2 piles",false,q);
		rr.save(r1);
		Reponse r2 = new Reponse("Aucune, je n'en ai pas",true,q);
		rr.save(r2);
		Reponse r3 = new Reponse("ça dépends le mode choisi",false,q);
		rr.save(r3);
		Reponse r4 = new Reponse("6 piles",false,q);
		rr.save(r4);
	}
}
