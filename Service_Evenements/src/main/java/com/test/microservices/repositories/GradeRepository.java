package com.test.microservices.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.microservices.pojos.Grade;

public interface GradeRepository extends MongoRepository<Grade, String> {
	public Grade findById(int id2);
	public Boolean existsById(int id2);
	@Query("{'nom' : {$regex:'?0', '$options' : 'i'}}")
	public List<Grade> findByNom(String nom);
	public Boolean existsByNom(String nom);
	public Grade findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Grade deleteById(int id2);
}
