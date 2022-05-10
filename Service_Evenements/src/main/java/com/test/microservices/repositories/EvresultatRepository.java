package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evresultat;

public interface EvresultatRepository extends MongoRepository<Evresultat, String> {
	public Evresultat findById(int id2);
	public Boolean existsById(int id2);
	public Evresultat findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evresultat deleteById(int id2);
}
