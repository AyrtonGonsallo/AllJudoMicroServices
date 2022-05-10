package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evequipe;

public interface EvequipeRepository extends MongoRepository<Evequipe, String> {
	public Evequipe findById(int id2);
	public Boolean existsById(int id2);
	public Evequipe findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evequipe deleteById(int id2);
}
