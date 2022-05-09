package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("pays")
@Data @NoArgsConstructor @AllArgsConstructor
public class Pays {
	@Id
	private String idMongo;
	@Field("ID")
	public int id;
	@Field("Abreviation")
	public String abreviation;
	public String NomPays;
	public String Flag;
}
