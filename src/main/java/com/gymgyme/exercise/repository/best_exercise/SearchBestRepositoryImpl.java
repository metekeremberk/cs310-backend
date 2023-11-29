package com.gymgyme.exercise.repository.best_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.gymgyme.exercise.model.BestExercise;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchBestRepositoryImpl implements SearchBestRepository {

	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;

	@Override
	public List<BestExercise> findByText(String text) {
		final List<BestExercise> exercises = new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("gymgyme");
		MongoCollection<Document> collection = database.getCollection("best-exercises");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
		    new Document("text", 
		    new Document("query", text)
		                .append("path", "muscle")))));
		
		result.forEach(doc -> exercises.add(converter.read(BestExercise.class, doc)));
		
		return exercises;
	}

}
