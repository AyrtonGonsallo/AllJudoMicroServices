package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("evenementimportants")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evenementimportant {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Nom;
	public String Text1;
	public String Text2;
	public String Text3;
	public String Logo;
	public int Evenement_id;
	public String Lien;
}
