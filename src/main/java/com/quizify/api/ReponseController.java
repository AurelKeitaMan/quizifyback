package com.quizify.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizify.model.Reponse;
import com.quizify.services.ServiceReponse;

@RestController
@RequestMapping("/api/reponse")
@CrossOrigin(origins = "http://localhost:4200/")
public class ReponseController {
	
 @Autowired
 private ServiceReponse reponseService;


	@GetMapping
	List<Reponse> sendAllReponse() {
		return reponseService.getReponse();
	}

	@GetMapping("/{id}")
	Reponse sendReponseById(@PathVariable long id) {
		return reponseService.getReponseById(id);
	}

	@PostMapping
	Reponse postReponse(@RequestBody Reponse reponse) {
		return reponseService.addReponse(reponse);
	}

	@PutMapping("/{id}")
	Reponse updatePlantById(@PathVariable long id,@RequestBody Reponse reponse) {
		return reponseService.updateReponse(id,reponse);
	}

	@DeleteMapping("/{id}")
	void deletePlantById(@PathVariable long id) {
		reponseService.deleteReponse(id);
	}

}
