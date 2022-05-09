package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.*;
@Document("commentaires")
@Data @NoArgsConstructor @AllArgsConstructor
public class Commentaire {
	@Id
	private String idMongo;
	@Field("ID")
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
