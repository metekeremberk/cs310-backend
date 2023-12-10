package com.gymgyme.exercise.controller;

import java.util.List;
import java.util.Set;

import com.gymgyme.exercise.model.ApplicationUser;
import com.gymgyme.exercise.model.WorkoutRoutine;
import com.gymgyme.exercise.repository.WorkoutRoutineRepository;
import com.gymgyme.exercise.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.gymgyme.exercise.model.BestExercise;
import com.gymgyme.exercise.model.Exercise;
import com.gymgyme.exercise.repository.BestExerciseRepository;
import com.gymgyme.exercise.repository.ExerciseRepository;

@RestController
@CrossOrigin
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepo;

    @Autowired
    BestExerciseRepository bestRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    WorkoutRoutineRepository workoutRoutineRepo;

    @GetMapping(value="/")
    public List<Exercise> getExercises() {
        return exerciseRepo.findAll();
    }

    @GetMapping(value="/best")
    public List<BestExercise> getBestExercises() {
        return bestRepo.findAll();
    }

    @GetMapping(value = "/workout")
    public Set<Long> getMyWorkouts() {
        ApplicationUser user = authenticationService.currentUser();

        return user.getWorkoutRoutineIds();
    }

    @GetMapping(value = "/workout?name={name}")
    public WorkoutRoutine createWorkoutRoutine(@PathVariable String name) {
        WorkoutRoutine routine = new WorkoutRoutine(name);
        System.out.println(routine);
        workoutRoutineRepo.save(routine);
        ApplicationUser user = authenticationService.currentUser();

        user.addWorkoutRoutine(workoutRoutineRepo.findByName(routine.getName()).getId());

        return routine;
    }
}