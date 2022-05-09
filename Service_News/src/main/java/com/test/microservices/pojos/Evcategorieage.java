package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("evcategorieage")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evcategorieage {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Intitule;
	public String Intitule_en;
}
