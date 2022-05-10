package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Evcategorieevenement;

public interface EvcategorieevenementRepository extends MongoRepository<Evcategorieevenement, String> {
	public Evcategorieevenement findById(int id2);
	public Boolean existsById(int id2);
	public Evcategorieevenement findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Evcategorieevenement deleteById(int id2);
}
