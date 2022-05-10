package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evenement;

public interface EvenementRepository extends MongoRepository<Evenement, String> {
	public Evenement findById(int id2);
	public Boolean existsById(int id2);
	public Evenement findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evenement deleteById(int id2);
}
