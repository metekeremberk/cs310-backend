package com.gymgyme.exercise.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gymgyme.exercise.model.Exercise;


public interface ExerciseRepository extends MongoRepository<Exercise, String> {

}