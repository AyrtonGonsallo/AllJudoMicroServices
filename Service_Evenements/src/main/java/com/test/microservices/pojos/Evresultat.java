package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document("evresultats")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evresultat {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Rang;
	public String Commentaire;
	public String Club;
	public int EvenementID;
	public int ChampionID;
	public int equipeID;
	@DocumentReference
	private Evenement evenement2;
	@DocumentReference
	private Champion champion2;
	@DocumentReference
	private Evequipe evequipe2;
	public String PoidID;
}
