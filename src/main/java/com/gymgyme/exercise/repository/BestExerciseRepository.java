package com.gymgyme.exercise.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymgyme.exercise.model.BestExercise;

public interface BestExerciseRepository extends MongoRepository<BestExercise, String> {

}