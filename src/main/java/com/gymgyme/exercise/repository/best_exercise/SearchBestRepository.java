package com.gymgyme.exercise.repository.best_exercise;

import java.util.List;

import com.gymgyme.exercise.model.BestExercise;

public interface SearchBestRepository {
	List<BestExercise> findByText(String text);
}
