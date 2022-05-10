package com.test.microservices.pojos;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;
@Document("champions")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Champion {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	private String IDold;
	@Field("Nom")
	private String nom;
	private char Sexe;
	private String PaysID;
	private String NvPaysID;
	private Date DateChangementNat2;
	private Date DateNaissance2;
	private String DateChangementNat;
	private String DateNaissance;
	private String LieuNaissance;
	private String Grade;
	@DocumentReference
	private Grade grade2;
	@DocumentReference
	private Club club2;
	@DocumentReference
	private Pays pays2;
	@DocumentReference
	private Pays nvpays2;
	private String Clubs;
	private int Taille;
	private int Poids;
	private String TokuiWaza;
	private String MainDirectrice;
	private String Activite;
	private String Forces;
	private String Idole;
	private String Idole2;
	private String Idole3;
	private String Idole4;
	private String Idole5;
	private String Idole6;
	private String Idole7;
	private String Lidole2;
	private String Lidole3;
	private String Lidole4;
	private String Lidole5;
	private String Lidole6;
	private String Lidole7;
	private String Anecdote;
	private String Phrase;
	private String VuPar;
	private String Site;
	
}