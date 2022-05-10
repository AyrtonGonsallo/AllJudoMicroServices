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

import com.test.microservices.dto.ChampionDto;
import com.test.microservices.mappers.ChampionDtoToChampion;
import com.test.microservices.pojos.Champion;
import com.test.microservices.repositories.ChampionRepository;

@RestController
public class ChampionController {
	ChampionDtoToChampion mapper;
	ChampionRepository championRepo;
	public ChampionController(ChampionRepository repo,ChampionDtoToChampion m) {
		this.championRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getChampionByIdMongo/{id}")
public ResponseEntity<ChampionDto> getChampion( @PathVariable String id) {
	if(championRepo.existsByIdMongo(id)) {
		Champion ab=championRepo.findByIdMongo( id);
		ChampionDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ChampionDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ChampionDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getChampionById/{id}")
public ResponseEntity<ChampionDto> getChampion( @PathVariable int id) {
	if(championRepo.existsById(id)) {
		Champion ab=championRepo.findById( id);
		ChampionDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ChampionDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ChampionDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllChampions")
public ResponseEntity<List<ChampionDto>> getChampion( ) {
	List<Champion> lab=championRepo.findAll();
	List<ChampionDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<ChampionDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addChampion")
public ResponseEntity<ChampionDto> addChampion(@RequestBody ChampionDto dto) {
	if(!championRepo.existsById(dto.getId())) {
		Champion ab=mapper.dtoToObject(dto);
		championRepo.save(ab);
		return new ResponseEntity<ChampionDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<ChampionDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateChampion/{id}")
public ResponseEntity<ChampionDto> updateChampion(@PathVariable int id,@RequestBody ChampionDto dto) {
	if(championRepo.existsById(id)) {
		Champion ab=mapper.dtoToObject(dto);
		championRepo.save(ab);
		return new ResponseEntity<ChampionDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ChampionDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteChampion/{id}")
public ResponseEntity<ChampionDto> deleteChampion(@PathVariable int id) {
	if(championRepo.existsById(id)) {
		Champion ab=championRepo.deleteById(id);
		ChampionDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<ChampionDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<ChampionDto>(HttpStatus.NOT_FOUND);
}


}
