package com.test.microservices.dto;

import java.util.Date;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ChampionDto {
	private String idMongo;
	private int id;
	private String iDold;
	private String nom;
	private char sexe;
	private String paysID;
	private String nvPaysID;
	private Date dateChangementNat2;
	private Date dateNaissance2;
	private String dateChangementNat;
	private String dateNaissance;
	private String lieuNaissance;
	private String grade;
	private String clubs;
	private int taille;
	private int poids;
	private String tokuiWaza;
	private String mainDirectrice;
	private String activite;
	private String forces;
	private String idole;
	private String idole2;
	private String idole3;
	private String idole4;
	private String idole5;
	private String idole6;
	private String idole7;
	private String lidole2;
	private String lidole3;
	private String lidole4;
	private String lidole5;
	private String lidole6;
	private String lidole7;
	private String anecdote;
	private String phrase;
	private String vuPar;
	private String site;
}
