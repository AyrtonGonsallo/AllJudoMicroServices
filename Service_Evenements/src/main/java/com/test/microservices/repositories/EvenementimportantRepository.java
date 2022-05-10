package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evenementimportant;

public interface EvenementimportantRepository extends MongoRepository<Evenementimportant, String> {
	public Evenementimportant findById(int id2);
	public Boolean existsById(int id2);
	public Evenementimportant findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evenementimportant deleteById(int id2);
}
