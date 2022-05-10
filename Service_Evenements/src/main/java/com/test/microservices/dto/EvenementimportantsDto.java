package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvenementimportantsDto {
	private String idMongo;
	private int id;
	public String nom;
	public String text1;
	public String text2;
	public String text3;
	public String logo;
	public int evenement_id;
	public String lien;
}
