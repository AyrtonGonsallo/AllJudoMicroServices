package com.test.microservices.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.microservices.dto.AdminDto;
import com.test.microservices.mappers.AdminDtoToAdmin;
import com.test.microservices.pojos.Admin;
import com.test.microservices.repositories.AdminRepository;

@RestController
public class AdminController {
	AdminDtoToAdmin mapper;
	AdminRepository adminRepo;
	public AdminController(AdminRepository repo,AdminDtoToAdmin m) {
		this.adminRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getAdminByIdMongo/{id}")
public ResponseEntity<AdminDto> getAdmin( @PathVariable String id) {
	if(adminRepo.existsByIdMongo(id)) {
		Admin ab=adminRepo.findByIdMongo( id);
		AdminDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<AdminDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAdminById/{id}")
public ResponseEntity<AdminDto> getAdmin( @PathVariable int id) {
	if(adminRepo.existsByAdminId(id)) {
		Admin ab=adminRepo.findByAdminId( id);
		AdminDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<AdminDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllAdmins")
public ResponseEntity<List<AdminDto>> getAdmin( ) {
	List<Admin> lab=adminRepo.findAll();
	List<AdminDto>ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<AdminDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addAdmin")
public ResponseEntity<AdminDto> addAdmin(@RequestBody AdminDto dto) {
	if(!adminRepo.existsByAdminId(dto.getAdminId())) {
		Admin ab=mapper.dtoToObject(dto);
		adminRepo.save(ab);
		return new ResponseEntity<AdminDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<AdminDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateAdmin/{id}")
public ResponseEntity<AdminDto> updateAdmin(@PathVariable int id,@RequestBody AdminDto dto) {
	if(adminRepo.existsByAdminId(id)) {
		Admin ab=mapper.dtoToObject(dto);
		adminRepo.save(ab);
		return new ResponseEntity<AdminDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteAdmin/{id}")
public ResponseEntity<AdminDto> deleteAdmin(@PathVariable int id) {
	if(adminRepo.existsByAdminId(id)) {
		Admin ab=adminRepo.deleteByAdminId(id);
		AdminDto dto =mapper.objectToDto(ab);
		return new ResponseEntity<AdminDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<AdminDto>(HttpStatus.NOT_FOUND);
}
}
