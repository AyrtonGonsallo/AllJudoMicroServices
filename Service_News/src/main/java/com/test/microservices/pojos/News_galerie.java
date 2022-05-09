package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("news_galerie")
@Data @NoArgsConstructor @AllArgsConstructor
public class News_galerie {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	@DocumentReference
	private News news2;
	public int news_id;
	public String path;
}
