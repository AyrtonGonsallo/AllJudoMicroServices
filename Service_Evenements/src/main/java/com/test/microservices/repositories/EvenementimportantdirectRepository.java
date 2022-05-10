package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evenementimportantdirect;

public interface EvenementimportantdirectRepository extends MongoRepository<Evenementimportantdirect, String> {
	public Evenementimportantdirect findById(int id2);
	public Boolean existsById(int id2);
	public Evenementimportantdirect findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evenementimportantdirect deleteById(int id2);
}
