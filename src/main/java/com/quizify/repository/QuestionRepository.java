package com.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quizify.model.Categorie;
import com.quizify.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByCategorie(Categorie categorie);
	List<Question> findByCategorieId(long categorieId);
	
    @Query(value = "SELECT q FROM Question q WHERE q.categorie.id = :categoryId ORDER BY RAND() LIMIT 3")
    List<Question> findRandomQuestionsByCategoryId(@Param("categoryId") Long categoryId);
}
