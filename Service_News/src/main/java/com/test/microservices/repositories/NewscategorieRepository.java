package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Newscategorie;

public interface NewscategorieRepository extends MongoRepository<Newscategorie, String> {
	public Newscategorie findById(int id2);
	public Boolean existsById(int id2);
	public Newscategorie findByIdMongo(String Id);
	public Boolean existsByIdMongo(String Id);
	public Newscategorie deleteById(int id2);
}
