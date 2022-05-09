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

import com.test.microservices.dto.EvcategorieageDto;
import com.test.microservices.mappers.EvcategorieageDtoToEvcategorieage;
import com.test.microservices.pojos.Evcategorieage;
import com.test.microservices.repositories.EvcategorieageRepository;

@RestController
public class EvcategorieageController {
	EvcategorieageDtoToEvcategorieage mapper;
	EvcategorieageRepository objetRepo;
	public EvcategorieageController(EvcategorieageRepository repo,EvcategorieageDtoToEvcategorieage m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getEvcategorieageByIdMongo/{id}")
public ResponseEntity<EvcategorieageDto> getEvcategorieage( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Evcategorieage ab=objetRepo.findByIdMongo( id);
		EvcategorieageDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieageDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieageDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getEvcategorieageById/{id}")
public ResponseEntity<EvcategorieageDto> getEvcategorieage( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evcategorieage ab=objetRepo.findById( id);
		EvcategorieageDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieageDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieageDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllEvcategorieages")
public ResponseEntity<List<EvcategorieageDto>> getEvcategorieage( ) {
	List<Evcategorieage> lab=objetRepo.findAll();
	List<EvcategorieageDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<EvcategorieageDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addEvcategorieage")
public ResponseEntity<EvcategorieageDto> addEvcategorieage(@RequestBody EvcategorieageDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Evcategorieage ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvcategorieageDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<EvcategorieageDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateEvcategorieage/{id}")
public ResponseEntity<EvcategorieageDto> updateEvcategorieage(@PathVariable int id,@RequestBody EvcategorieageDto dto) {
	if(objetRepo.existsById(id)) {
		Evcategorieage ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<EvcategorieageDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieageDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteEvcategorieage/{id}")
public ResponseEntity<EvcategorieageDto> deleteEvcategorieage(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Evcategorieage ab=objetRepo.deleteById(id);
		EvcategorieageDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<EvcategorieageDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<EvcategorieageDto>(HttpStatus.NOT_FOUND);
}
}
