package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvenementimportantdirectDto {
	private String idMongo;
	private int id;
	public java.util.Date date;
	public String admin;
	public String titre;
	public String texte;
	public int evenement_important_id;
	public Boolean une;
}
