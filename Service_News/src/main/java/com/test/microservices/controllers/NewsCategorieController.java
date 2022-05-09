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

import com.test.microservices.dto.NewscategorieDto;
import com.test.microservices.mappers.NewscategorieDtoToNewscategorie;
import com.test.microservices.pojos.Newscategorie;
import com.test.microservices.repositories.NewscategorieRepository;

@RestController
public class NewsCategorieController {
	NewscategorieDtoToNewscategorie mapper;
	NewscategorieRepository objetRepo;
	public NewsCategorieController(NewscategorieRepository repo,NewscategorieDtoToNewscategorie m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNewscategorieByIdMongo/{id}")
public ResponseEntity<NewscategorieDto> getNewscategorie( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		Newscategorie ab=objetRepo.findByIdMongo( id);
		NewscategorieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewscategorieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewscategorieDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNewscategorieById/{id}")
public ResponseEntity<NewscategorieDto> getNewscategorie( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Newscategorie ab=objetRepo.findById( id);
		NewscategorieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewscategorieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewscategorieDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNewscategories")
public ResponseEntity<List<NewscategorieDto>> getNewscategorie( ) {
	List<Newscategorie> lab=objetRepo.findAll();
	List<NewscategorieDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<NewscategorieDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addNewscategorie")
public ResponseEntity<NewscategorieDto> addNewscategorie(@RequestBody NewscategorieDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		Newscategorie ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<NewscategorieDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<NewscategorieDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNewscategorie/{id}")
public ResponseEntity<NewscategorieDto> updateNewscategorie(@PathVariable int id,@RequestBody NewscategorieDto dto) {
	if(objetRepo.existsById(id)) {
		Newscategorie ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<NewscategorieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewscategorieDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNewscategorie/{id}")
public ResponseEntity<NewscategorieDto> deleteNewscategorie(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		Newscategorie ab=objetRepo.deleteById(id);
		NewscategorieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewscategorieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewscategorieDto>(HttpStatus.NOT_FOUND);
}


}
