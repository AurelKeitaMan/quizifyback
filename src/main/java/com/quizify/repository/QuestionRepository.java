package com.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizify.model.Categorie;
import com.quizify.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	List<Question> findByCategorie(Categorie categorie);
}
