package com.gymgyme.exercise.repository;

import com.gymgyme.exercise.model.WorkoutRoutine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WorkoutRoutineRepository extends MongoRepository<WorkoutRoutine, String> {
    @Query("{name: '?0'}")
    WorkoutRoutine findByName(String name);
}
