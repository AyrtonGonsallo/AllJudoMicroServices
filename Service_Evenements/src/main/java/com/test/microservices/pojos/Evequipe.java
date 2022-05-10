package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import com.test.microservices.enums.Sexe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document("evequipe")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evequipe {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public int Rang;
	public String NomEquipe;
	public String Equipe;
	public Sexe Sexe;
	public int evenementID;
	@DocumentReference
	private Evenement evenement2;
}
