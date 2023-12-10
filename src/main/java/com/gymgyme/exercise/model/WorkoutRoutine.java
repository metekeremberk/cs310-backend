package com.gymgyme.exercise.model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "workout-routines")
public class WorkoutRoutine {

    @Id
    private Long id;

    private String name;

    private Set<Exercise> exercises;

    public WorkoutRoutine(String name) {
        super();
        this.name = name;
        this.exercises = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "WorkoutRoutine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exercises=" + exercises +
                '}';
    }
}