package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document("clubs")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Club {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	@DocumentReference
	private Pays Pays2;
	public String pays;
	public String departement;
	public String club;
	public String responsable;
	public String telephone;
	public String mel;
	public String site;
	public String description;
	public String ville;
	public String CP;
	public String adresse;
	public String gcoo1;
	public String gcoo2;
	public String gaddress;
	public byte Valide;
}
