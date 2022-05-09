package com.test.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.News_galerie;

public interface News_galerieRepository extends MongoRepository<News_galerie, String> {
	public News_galerie findById(int id2);
	public Boolean existsById(int id2);
	public News_galerie findByIdMongo(String Id);
	public Boolean existsByIdMongo(String Id);
	public News_galerie deleteById(int id2);
}
