package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvcategorieevenementDto {
	private String idMongo;
	private int id;
	public String intitule;
	public String intitule_en;
	public int tri;
	public Boolean club;
	public Boolean inter;
	public Boolean classement;
}
