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

import com.test.microservices.dto.ClubDto;
import com.test.microservices.mappers.ClubDtoToClub;
import com.test.microservices.pojos.Club;
import com.test.microservices.repositories.ClubRepository;
@RestController
public class ClubController {
	ClubDtoToClub mapper;
	ClubRepository clubRepo;
	public ClubController(ClubRepository repo,ClubDtoToClub m) {
		this.clubRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getClubByIdMongo/{id}")
public ResponseEntity<ClubDto> getClub( @PathVariable String id) {
	if(clubRepo.existsByIdMongo(id)) {
		Club ab=clubRepo.findByIdMongo( id);
		ClubDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ClubDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ClubDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getClubById/{id}")
public ResponseEntity<ClubDto> getClub( @PathVariable int id) {
	if(clubRepo.existsById(id)) {
		Club ab=clubRepo.findById( id);
		ClubDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ClubDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ClubDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllClubs")
public ResponseEntity<List<ClubDto>> getClub( ) {
	List<Club> lab=clubRepo.findAll();
	List<ClubDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<ClubDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addClub")
public ResponseEntity<ClubDto> addClub(@RequestBody ClubDto dto) {
	if(!clubRepo.existsById(dto.getId())) {
		Club ab=mapper.dtoToObject(dto);
		clubRepo.save(ab);
		return new ResponseEntity<ClubDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<ClubDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateClub/{id}")
public ResponseEntity<ClubDto> updateClub(@PathVariable int id,@RequestBody ClubDto dto) {
	if(clubRepo.existsById(id)) {
		Club ab=mapper.dtoToObject(dto);
		clubRepo.save(ab);
		return new ResponseEntity<ClubDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ClubDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteClub/{id}")
public ResponseEntity<ClubDto> deleteClub(@PathVariable int id) {
	if(clubRepo.existsById(id)) {
		Club ab=clubRepo.deleteById(id);
		ClubDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ClubDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ClubDto>(HttpStatus.NOT_FOUND);
}



}
