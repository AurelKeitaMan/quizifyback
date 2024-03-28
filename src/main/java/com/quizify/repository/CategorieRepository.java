package com.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quizify.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
	
	@Query("SELECT c FROM Categorie c WHERE (SELECT COUNT(q) FROM Question q WHERE q.categorie.id = c.id) >= 3")
    List<Categorie> findCategoriesWithAtLeastThreeQuestion();
}
