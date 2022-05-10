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

import com.test.microservices.dto.EvcategorieevenementDto;
import com.test.microservices.mappers.EvcategorieevenementDtoToEvcategorieevenement;
import com.test.microservices.pojos.Evcategorieevenement;
import com.test.microservices.repositories.EvcategorieevenementRepository;
@RestController
public class EvcategorieevenementController {
	EvcategorieevenementDtoToEvcategorieevenement mapper;
	EvcategorieevenementRepository objetRepo;
	public EvcategorieevenementController(EvcategorieevenementRepository repo,EvcategorieevenementDtoToEvcategorieevenement m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvcategorieevenementByIdMongo/{id}")
public ResponseEntity<EvcategorieevenementDto> getEvcategorieevenement( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Evcategorieevenement ab=objetRepo.findByIdMongo( id);
		EvcategorieevenementDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieevenementDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieevenementDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvcategorieevenementById/{id}")
public ResponseEntity<EvcategorieevenementDto> getEvcategorieevenement( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evcategorieevenement ab=objetRepo.findById( id);
		EvcategorieevenementDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieevenementDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieevenementDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvcategorieevenements")
public ResponseEntity<List<EvcategorieevenementDto>> getEvcategorieevenement( ) {
	List<Evcategorieevenement> lab=objetRepo.findAll();
	List<EvcategorieevenementDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<EvcategorieevenementDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addEvcategorieevenement")
public ResponseEntity<EvcategorieevenementDto> addEvcategorieevenement(@RequestBody EvcategorieevenementDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Evcategorieevenement ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvcategorieevenementDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<EvcategorieevenementDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvcategorieevenement/{id}")
public ResponseEntity<EvcategorieevenementDto> updateEvcategorieevenement(@PathVariable int id,@RequestBody EvcategorieevenementDto dto) {
	if(objetRepo.existsById(id)) {
		Evcategorieevenement ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvcategorieevenementDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieevenementDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvcategorieevenement/{id}")
public ResponseEntity<EvcategorieevenementDto> deleteEvcategorieevenement(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evcategorieevenement ab=objetRepo.deleteById(id);
		EvcategorieevenementDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieevenementDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieevenementDto>(HttpStatus.NOT_FOUND);
}
}
