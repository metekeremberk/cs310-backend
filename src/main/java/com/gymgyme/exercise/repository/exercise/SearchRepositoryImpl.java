package com.gymgyme.exercise.repository.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.gymgyme.exercise.model.Exercise;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class SearchRepositoryImpl implements SearchRepository {
	
	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter converter;

	@Override
	public List<Exercise> findByName(String text, int limit) {
		final List<Exercise> exercises = new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("gymgyme");
		MongoCollection<Document> collection = database.getCollection("all-exercises");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
			new Document("$search", 
					new Document("text", 
							new Document("query", text).append("path", "title"))), 
		    new Document("$sort", 
		    	    new Document("title", 1L)), 
		    new Document("$limit", limit)));
		
		result.forEach(doc -> exercises.add(converter.read(Exercise.class, doc)));
		
		return exercises;
	}

	@Override
	public List<Exercise> findByMuscles(String text, int limit) {
		final List<Exercise> exercises = new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("gymgyme");
		MongoCollection<Document> collection = database.getCollection("all-exercises");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
			new Document("$search", 
					new Document("text", 
							new Document("query", text).append("path", Arrays.asList("primary", "secondary")))), 
		    new Document("$limit", limit)));
		
		result.forEach(doc -> exercises.add(converter.read(Exercise.class, doc)));
		
		return exercises;
	}
	
}
