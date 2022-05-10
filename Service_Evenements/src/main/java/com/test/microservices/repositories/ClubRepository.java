package com.test.microservices.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.microservices.pojos.Club;

public interface ClubRepository extends MongoRepository<Club, String> {
	public Club findById(int id2);
	public Boolean existsById(int id2);
	public List<Club> findByClub(String club);
	public Boolean existsByClub(String club);
	public Club findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Club deleteById(int id2);
}
