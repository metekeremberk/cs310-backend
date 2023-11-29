package com.gymgyme.exercise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymgyme.exercise.model.BestExercise;
import com.gymgyme.exercise.model.Exercise;
import com.gymgyme.exercise.repository.best_exercise.BestExerciseRepository;
import com.gymgyme.exercise.repository.exercise.ExerciseRepository;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class ExerciseController {
	
	@Autowired
	ExerciseRepository exerciseRepo;
	
	@Autowired
	BestExerciseRepository bestRepo;
	
	@Hidden
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("swagger-ui");
	}
	
	@GetMapping(value="/exercises")
	public List<Exercise> getExercises() {
		return exerciseRepo.findAll(); 
	}
	
	@GetMapping(value="/best")
	public List<BestExercise> getBestExercises() {
		return bestRepo.findAll(); 
	}
}
