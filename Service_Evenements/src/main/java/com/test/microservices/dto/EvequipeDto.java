package com.test.microservices.dto;


import com.test.microservices.enums.Sexe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class EvequipeDto {
	private String idMongo;
	private int id;
	public int rang;
	public String nomEquipe;
	public String equipe;
	public Sexe sexe;
	public int evenementID;
}
