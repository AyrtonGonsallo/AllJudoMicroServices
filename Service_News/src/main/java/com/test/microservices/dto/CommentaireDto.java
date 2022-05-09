package com.test.microservices.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class CommentaireDto {
	private String idMongo;
	private int id;
	public java.util.Date date;
	public String commentaire;
	public Boolean valide;
	public int user_id;
	public int news_id;
	public int video_id;
	public int champion_id;
	public String positif;
	public String negatif;
}
