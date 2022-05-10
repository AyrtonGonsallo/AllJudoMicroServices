package com.test.microservices.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.test.microservices.pojos.Champion;

public interface ChampionRepository extends MongoRepository<Champion, String> {
	@Query("{Nom:'?0'}")
    Champion findByNom(String Nom);
    Boolean existsByNom(String Nom);
    @Query(value="{PaysID:'?0'}", fields="{'Nom' : 1, 'PaysID' : 1}")
    List<Champion> findAll(String PaysID);
    
    public long count();
    
    @Query(value="{$nor:[{Clubs:''}]}", fields="{'ID':1,'Nom' : 1, 'PaysID' : 1,'Clubs':1}")
    List<Champion> avecClubs();
    
    public Champion findById(int id2);
	public Boolean existsById(int id2);
	public Champion findByIdMongo(String idMongo);
	public Boolean existsByIdMongo(String idMongo);
	public Champion deleteById(int id2);
    
}
