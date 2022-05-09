package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class News_galerieDto {
	private String idMongo;
	private int id;
	public int news_id;
	public String path;
}
