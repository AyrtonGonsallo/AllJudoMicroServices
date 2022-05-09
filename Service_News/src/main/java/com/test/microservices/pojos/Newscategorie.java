package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("newscategorie")
@Data @NoArgsConstructor @AllArgsConstructor
public class Newscategorie {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Intitule;
}
