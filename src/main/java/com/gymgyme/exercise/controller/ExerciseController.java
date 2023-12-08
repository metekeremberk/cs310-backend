package com.gymgyme.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymgyme.exercise.model.BestExercise;
import com.gymgyme.exercise.model.Exercise;
import com.gymgyme.exercise.repository.BestExerciseRepository;
import com.gymgyme.exercise.repository.ExerciseRepository;

@RestController
@CrossOrigin
@RequestMapping("/")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepo;

    @Autowired
    BestExerciseRepository bestRepo;

    @GetMapping(value="/exercises")
    public List<Exercise> getExercises() {
        return exerciseRepo.findAll();
    }

    @GetMapping(value="/best")
    public List<BestExercise> getBestExercises() {
        return bestRepo.findAll();
    }
}