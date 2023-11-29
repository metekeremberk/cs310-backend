package com.gymgyme.exercise.model;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="best-exercises")
public class BestExercise {
	private String muscle;
	private Exercise exercises[];
	
	public String getMuscle() {
		return muscle;
	}
	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}
	public Exercise[] getExercises() {
		return exercises;
	}
	public void setExercises(Exercise exercises[]) {
		this.exercises = exercises;
	}
	
	@Override
    public String toString() {
        return "{" +
                "Muscle: '" + muscle + "',\n" +
                "Exercises: " + Arrays.toString(exercises) +
                "\n}";
    }
}
