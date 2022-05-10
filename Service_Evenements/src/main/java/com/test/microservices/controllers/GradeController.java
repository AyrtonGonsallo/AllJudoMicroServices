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

import com.test.microservices.dto.GradeDto;
import com.test.microservices.mappers.GradeDtoToGrade;
import com.test.microservices.pojos.Grade;
import com.test.microservices.repositories.GradeRepository;

@RestController
public class GradeController {
	GradeDtoToGrade mapper;
	GradeRepository objetRepo;
	public GradeController(GradeRepository repo,GradeDtoToGrade m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getGradeByIdMongo/{id}")
public ResponseEntity<GradeDto> getGrade( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Grade ab=objetRepo.findByIdMongo( id);
		GradeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<GradeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<GradeDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getGradeById/{id}")
public ResponseEntity<GradeDto> getGrade( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Grade ab=objetRepo.findById( id);
		GradeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<GradeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<GradeDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllGrades")
public ResponseEntity<List<GradeDto>> getGrade( ) {
	List<Grade> lab=objetRepo.findAll();
	List<GradeDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<GradeDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addGrade")
public ResponseEntity<GradeDto> addGrade(@RequestBody GradeDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Grade ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<GradeDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<GradeDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateGrade/{id}")
public ResponseEntity<GradeDto> updateGrade(@PathVariable int id,@RequestBody GradeDto dto) {
	if(objetRepo.existsById(id)) {
		Grade ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<GradeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<GradeDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteGrade/{id}")
public ResponseEntity<GradeDto> deleteGrade(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Grade ab=objetRepo.deleteById(id);
		GradeDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<GradeDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<GradeDto>(HttpStatus.NOT_FOUND);
}
}

