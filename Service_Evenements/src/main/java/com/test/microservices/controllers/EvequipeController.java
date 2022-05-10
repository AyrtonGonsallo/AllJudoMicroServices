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

import com.test.microservices.dto.EvequipeDto;
import com.test.microservices.mappers.EvequipeDtoToEvequipe;
import com.test.microservices.pojos.Evequipe;
import com.test.microservices.repositories.EvequipeRepository;
@RestController
public class EvequipeController {
	EvequipeDtoToEvequipe mapper;
	EvequipeRepository objetRepo;
	public EvequipeController(EvequipeRepository repo,EvequipeDtoToEvequipe m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvequipeByIdMongo/{id}")
public ResponseEntity<EvequipeDto> getEvequipe( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Evequipe ab=objetRepo.findByIdMongo( id);
		EvequipeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvequipeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvequipeDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvequipeById/{id}")
public ResponseEntity<EvequipeDto> getEvequipe( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evequipe ab=objetRepo.findById( id);
		EvequipeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvequipeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvequipeDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvequipes")
public ResponseEntity<List<EvequipeDto>> getEvequipe( ) {
	List<Evequipe> lab=objetRepo.findAll();
	List<EvequipeDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<EvequipeDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addEvequipe")
public ResponseEntity<EvequipeDto> addEvequipe(@RequestBody EvequipeDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Evequipe ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvequipeDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<EvequipeDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvequipe/{id}")
public ResponseEntity<EvequipeDto> updateEvequipe(@PathVariable int id,@RequestBody EvequipeDto dto) {
	if(objetRepo.existsById(id)) {
		Evequipe ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvequipeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvequipeDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvequipe/{id}")
public ResponseEntity<EvequipeDto> deleteEvequipe(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evequipe ab=objetRepo.deleteById(id);
		EvequipeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvequipeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvequipeDto>(HttpStatus.NOT_FOUND);
}

}
