package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ClubDto {
	private String idMongo;
	private int id;
	public String pays;
	public String departement;
	public String club;
	public String responsable;
	public String telephone;
	public String mel;
	public String site;
	public String description;
	public String ville;
	public String cP;
	public String adresse;
	public String gcoo1;
	public String gcoo2;
	public String gaddress;
	public byte valide;
}
