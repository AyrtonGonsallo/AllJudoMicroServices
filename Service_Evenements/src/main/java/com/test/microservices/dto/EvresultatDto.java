package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvresultatDto {
	private String idMongo;
	private int id;
	public String rang;
	public String commentaire;
	public String club;
	public int evenementID;
	public int championID;
	public int equipeID;
	public String poidID;
}
