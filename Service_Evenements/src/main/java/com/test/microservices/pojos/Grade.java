package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("grades")
@Data @NoArgsConstructor @AllArgsConstructor
public class Grade {
	@Id
	private String idMongo;
	@Field("id_grade")
	public int id;
	public String nom;
}
