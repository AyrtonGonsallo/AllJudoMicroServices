package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import com.test.microservices.enums.CategorieEvenementSexe;
import com.test.microservices.enums.TypeEvenement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document("evenements")
@Data @NoArgsConstructor @AllArgsConstructor
public class Evenement {
	@Id
	private String idMongo;
	@Field("ID")
	private int id;
	public String Nom;
	public CategorieEvenementSexe Sexe;
	public java.util.Date DateDebut;
	public java.util.Date DateFin;
	public java.util.Date DatePub;
	public String Presentation;
	public Boolean Visible;
	public TypeEvenement Type;
	public String Document1;
	public String Document2;
	public String Document3;
	public String Contact;
	public String Telephone;
	public String Mail;
	public String Web;
	public Boolean Valider;
	public Boolean Pack;
	public String PaysID;
	public int CategorieID;
	public int CategorieageID;
	@DocumentReference
	private Evcategorieage evcategorieage2;
	@DocumentReference
	private Evcategorieevenement evcategorieevenement2;
	@DocumentReference
	private Pays pays2;
	public int compteur;
}
