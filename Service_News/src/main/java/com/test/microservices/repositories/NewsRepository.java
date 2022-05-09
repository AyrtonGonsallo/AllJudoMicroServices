package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.News;

public interface NewsRepository extends MongoRepository<News, String> {
	public News findById(int id2);
	public Boolean existsById(int id2);
	public News findByIdMongo(String Id);
	public Boolean existsByIdMongo(String Id);
	public News deleteById(int id2);
}
