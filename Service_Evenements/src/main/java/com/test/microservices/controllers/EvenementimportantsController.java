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

import com.test.microservices.dto.EvenementimportantsDto;
import com.test.microservices.mappers.EvenementimportantsDtoToEvenementimportants;
import com.test.microservices.pojos.Evenementimportant;
import com.test.microservices.repositories.EvenementimportantRepository;
@RestController
public class EvenementimportantsController {
	EvenementimportantsDtoToEvenementimportants mapper;
	EvenementimportantRepository objetRepo;
	public EvenementimportantsController(EvenementimportantRepository repo,EvenementimportantsDtoToEvenementimportants m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvenementimportantsByIdMongo/{id}")
public ResponseEntity<EvenementimportantsDto> getEvenementimportants( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Evenementimportant ab=objetRepo.findByIdMongo( id);
		EvenementimportantsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantsDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvenementimportantsById/{id}")
public ResponseEntity<EvenementimportantsDto> getEvenementimportants( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evenementimportant ab=objetRepo.findById( id);
		EvenementimportantsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantsDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvenementimportantss")
public ResponseEntity<List<EvenementimportantsDto>> getEvenementimportants( ) {
	List<Evenementimportant> lab=objetRepo.findAll();
	List<EvenementimportantsDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<EvenementimportantsDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addEvenementimportants")
public ResponseEntity<EvenementimportantsDto> addEvenementimportants(@RequestBody EvenementimportantsDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Evenementimportant ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvenementimportantsDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<EvenementimportantsDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvenementimportants/{id}")
public ResponseEntity<EvenementimportantsDto> updateEvenementimportants(@PathVariable int id,@RequestBody EvenementimportantsDto dto) {
	if(objetRepo.existsById(id)) {
		Evenementimportant ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvenementimportantsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantsDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvenementimportants/{id}")
public ResponseEntity<EvenementimportantsDto> deleteEvenementimportants(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evenementimportant ab=objetRepo.deleteById(id);
		EvenementimportantsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantsDto>(HttpStatus.NOT_FOUND);
}
}
