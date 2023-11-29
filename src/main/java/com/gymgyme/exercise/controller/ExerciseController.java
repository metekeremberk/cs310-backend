package com.gymgyme.exercise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymgyme.exercise.model.BestExercise;
import com.gymgyme.exercise.model.Exercise;
import com.gymgyme.exercise.repository.best_exercise.BestExerciseRepository;
import com.gymgyme.exercise.repository.best_exercise.SearchBestRepository;
import com.gymgyme.exercise.repository.exercise.ExerciseRepository;
import com.gymgyme.exercise.repository.exercise.SearchRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class ExerciseController {
	
	@Autowired
	ExerciseRepository exerciseRepo;
	
	@Autowired
	SearchRepository searchRepo;
	
	@Autowired
	BestExerciseRepository bestRepo;
	
	@Autowired
	SearchBestRepository searchBestRepo;
	
	@Hidden
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui");
	}
	
	@GetMapping(value="/exercises")
	public List<Exercise> getExercises() {
		return exerciseRepo.findAll(); 
	}
	
	@GetMapping(value="/exercises/{text}&{limit}")
	public List<Exercise> searchExercises(@PathVariable String text, @PathVariable int limit) {
		return searchRepo.findByName(text, limit);
	}
	
	@GetMapping(value="/best")
	public List<BestExercise> getBestExercises() {
		return bestRepo.findAll(); 
	}
	
	@GetMapping(value="/best/{text}")
	public List<BestExercise> searchBestExercises(@PathVariable String text) {
		return searchBestRepo.findByText(text);
	}
}
