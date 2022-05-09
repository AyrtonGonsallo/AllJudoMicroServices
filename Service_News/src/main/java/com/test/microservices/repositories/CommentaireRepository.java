package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Commentaire;

public interface CommentaireRepository extends MongoRepository<Commentaire, String> {
	public Commentaire findById(int id2);
	public Boolean existsById(int id2);
	public Commentaire findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Commentaire deleteById(int id2);
}
