package com.gymgyme.exercise.repository.exercise;

import java.util.List;

import com.gymgyme.exercise.model.Exercise;

public interface SearchRepository {
	List<Exercise> findByName(String text, int limit);
	List<Exercise> findByMuscles(String text, int limit);
}
