package com.quizify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizify.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
