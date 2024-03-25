package com.quizify.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizify.Model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
