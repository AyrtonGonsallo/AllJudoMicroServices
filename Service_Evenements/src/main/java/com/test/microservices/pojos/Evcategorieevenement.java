package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("evcategorieevenement")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evcategorieevenement {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Intitule;
	public String Intitule_en;
	public int tri;
	public Boolean club;
	public Boolean inter;
	public Boolean classement;
}
