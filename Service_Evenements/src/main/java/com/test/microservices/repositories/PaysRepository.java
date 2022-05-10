package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.microservices.pojos.Pays;

public interface PaysRepository extends MongoRepository<Pays, String> {
	public Pays findById(int id2);
	public Boolean existsById(int id2);
	public Pays findByIdMongo(String Id);
	public Pays findByAbreviation(String Abr);
	public Boolean existsByAbreviation(String Abr);
	public Boolean existsByIdMongo(String Id);
	public Pays deleteById(int id2);
}
