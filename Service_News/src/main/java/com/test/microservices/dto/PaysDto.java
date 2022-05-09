package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class PaysDto {
	private String idMongo;
	public int id;
	public String abreviation;
	public String nomPays;
	public String flag;
}
