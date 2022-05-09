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

import com.test.microservices.dto.PaysDto;
import com.test.microservices.mappers.PaysDtoToPays;
import com.test.microservices.pojos.Pays;
import com.test.microservices.pojos.Pays;
import com.test.microservices.repositories.PaysRepository;

@RestController
public class PaysController {
	PaysRepository paysRepo;
	PaysDtoToPays mapper;
	public PaysController(PaysRepository repo,PaysDtoToPays m) {
		this.paysRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getPaysByIdMongo/{id}")
public ResponseEntity<PaysDto> getPays( @PathVariable String id) {
	if(paysRepo.existsByIdMongo(id)) {
		Pays ab=paysRepo.findByIdMongo( id);
		PaysDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<PaysDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<PaysDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getPaysById/{id}")
public ResponseEntity<PaysDto> getPays( @PathVariable int id) {
	if(paysRepo.existsById(id)) {
		Pays ab=paysRepo.findById( id);
		PaysDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<PaysDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<PaysDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllPays")
public ResponseEntity<List<PaysDto>> getPays( ) {
	List<Pays> lab=paysRepo.findAll();
	List<PaysDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<PaysDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addPays")
public ResponseEntity<PaysDto> addPays(@RequestBody PaysDto dto) {
	if(!paysRepo.existsById(dto.getId())) {
		Pays ab=mapper.dtoToObject(dto);
		paysRepo.save(ab);
		return new ResponseEntity<PaysDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<PaysDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updatePays/{id}")
public ResponseEntity<PaysDto> updatePays(@PathVariable int id,@RequestBody PaysDto dto) {
	if(paysRepo.existsById(id)) {
		Pays ab=mapper.dtoToObject(dto);
		paysRepo.save(ab);
		return new ResponseEntity<PaysDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<PaysDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deletePays/{id}")
public ResponseEntity<PaysDto> deletePays(@PathVariable int id) {
	if(paysRepo.existsById(id)) {
		Pays ab=paysRepo.deleteById(id);
		PaysDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<PaysDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<PaysDto>(HttpStatus.NOT_FOUND);
}


}
