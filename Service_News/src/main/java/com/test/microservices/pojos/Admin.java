package com.test.microservices.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.test.microservices.enums.PermissionAdmin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document("admin")
@Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Admin {
	@Id
	public String idMongo;
	@Field("adminID")
	public int adminId;
	public String login;
	public PermissionAdmin permission;
	public String password;
}
