package com.test.microservices.dto;



import com.test.microservices.enums.TypeNews;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class NewsDto {
	private String idMongo;
	private int id;
	public java.util.Date date;
	public String source;
	public String titre;
	public String titre_en;
	public String chapo;
	public String texte;
	public String photo;
	public TypeNews type;
	public String nom;
	public String url;
	public String legende;
	public String lien1;
	public String textlien1;
	public String lien2;
	public String textlien2;
	public String lien3;
	public String textlien3;
	public Boolean aLaUne;
	public Boolean aLaDeux;
	public int evenementID;
	public int categorieID;
	public String admin;
}
