package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evcategorieage;

public interface EvcategorieageRepository extends MongoRepository<Evcategorieage, String> {
	public Evcategorieage findById(int id2);
	public Boolean existsById(int id2);
	public Evcategorieage findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evcategorieage deleteById(int id2);
}
