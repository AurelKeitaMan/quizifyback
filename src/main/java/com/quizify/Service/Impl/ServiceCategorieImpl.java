package com.quizify.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizify.Repository.CategorieRepository;

@Service
public class ServiceCategorieImpl {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

}
