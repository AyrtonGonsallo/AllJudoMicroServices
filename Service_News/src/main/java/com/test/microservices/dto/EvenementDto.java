package com.test.microservices.dto;


import com.test.microservices.enums.CategorieEvenementSexe;
import com.test.microservices.enums.TypeEvenement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvenementDto {
	private String idMongo;
	private int id;
	public String nom;
	public CategorieEvenementSexe sexe;
	public java.util.Date dateDebut;
	public java.util.Date dateFin;
	public java.util.Date datePub;
	public String presentation;
	public Boolean visible;
	public TypeEvenement type;
	public String document1;
	public String document2;
	public String document3;
	public String contact;
	public String telephone;
	public String mail;
	public String web;
	public Boolean valider;
	public Boolean pack;
	public String paysID;
	public int categorieID;
	public int categorieageID;
	public int compteur;
}
