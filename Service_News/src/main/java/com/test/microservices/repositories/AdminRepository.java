package com.test.microservices.repositories;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.test.microservices.pojos.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	public Admin findByAdminId(int id2);
	public Boolean existsByAdminId(int id2);
	public Boolean existsByLogin(String login);
	public Admin findByLogin(String login);
	public Admin findByIdMongo(String Id);
	public Boolean existsByIdMongo(String Id);
	public Admin deleteByAdminId(int id2);
}
