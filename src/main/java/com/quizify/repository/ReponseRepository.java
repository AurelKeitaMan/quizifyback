package com.quizify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizify.model.Reponse;

public interface ReponseRepository extends JpaRepository<Reponse, Long>{
	List<Reponse> findByQuestionId(Long id);

}
 