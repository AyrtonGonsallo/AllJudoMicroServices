package com.test.microservices.dto;



import com.test.microservices.enums.PermissionAdmin;


import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor
public class AdminDto {
	public String idMongo;
	public int adminId;
	public String login;
	public PermissionAdmin permission;
	public String password;
}
