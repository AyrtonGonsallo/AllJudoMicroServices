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

import com.test.microservices.dto.EvenementimportantdirectDto;
import com.test.microservices.mappers.EvenementimportantdirectDtoToEvenementimportantdirect;
import com.test.microservices.pojos.Evenementimportantdirect;
import com.test.microservices.repositories.EvenementimportantdirectRepository;
@RestController
public class EvenementimportantdirectController {
	EvenementimportantdirectDtoToEvenementimportantdirect mapper;
	EvenementimportantdirectRepository objetRepo;
	public EvenementimportantdirectController(EvenementimportantdirectRepository repo,EvenementimportantdirectDtoToEvenementimportantdirect m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvenementimportantdirectByIdMongo/{id}")
public ResponseEntity<EvenementimportantdirectDto> getEvenementimportantdirect( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Evenementimportantdirect ab=objetRepo.findByIdMongo( id);
		EvenementimportantdirectDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantdirectDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantdirectDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvenementimportantdirectById/{id}")
public ResponseEntity<EvenementimportantdirectDto> getEvenementimportantdirect( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evenementimportantdirect ab=objetRepo.findById( id);
		EvenementimportantdirectDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantdirectDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantdirectDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvenementimportantdirects")
public ResponseEntity<List<EvenementimportantdirectDto>> getEvenementimportantdirect( ) {
	List<Evenementimportantdirect> lab=objetRepo.findAll();
	List<EvenementimportantdirectDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<EvenementimportantdirectDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addEvenementimportantdirect")
public ResponseEntity<EvenementimportantdirectDto> addEvenementimportantdirect(@RequestBody EvenementimportantdirectDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Evenementimportantdirect ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvenementimportantdirectDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<EvenementimportantdirectDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvenementimportantdirect/{id}")
public ResponseEntity<EvenementimportantdirectDto> updateEvenementimportantdirect(@PathVariable int id,@RequestBody EvenementimportantdirectDto dto) {
	if(objetRepo.existsById(id)) {
		Evenementimportantdirect ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvenementimportantdirectDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantdirectDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvenementimportantdirect/{id}")
public ResponseEntity<EvenementimportantdirectDto> deleteEvenementimportantdirect(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evenementimportantdirect ab=objetRepo.deleteById(id);
		EvenementimportantdirectDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvenementimportantdirectDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvenementimportantdirectDto>(HttpStatus.NOT_FOUND);
}
}
