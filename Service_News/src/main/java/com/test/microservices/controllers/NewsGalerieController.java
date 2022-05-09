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

import com.test.microservices.dto.News_galerieDto;
import com.test.microservices.mappers.News_galerieDtoToNews_galerie;
import com.test.microservices.pojos.News_galerie;
import com.test.microservices.repositories.News_galerieRepository;
@RestController
public class NewsGalerieController {
	News_galerieDtoToNews_galerie mapper;
	News_galerieRepository objetRepo;
	public NewsGalerieController(News_galerieRepository repo,News_galerieDtoToNews_galerie m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNews_galerieByIdMongo/{id}")
public ResponseEntity<News_galerieDto> getNews_galerie( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		News_galerie ab=objetRepo.findByIdMongo( id);
		News_galerieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<News_galerieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerieDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNews_galerieById/{id}")
public ResponseEntity<News_galerieDto> getNews_galerie( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		News_galerie ab=objetRepo.findById( id);
		News_galerieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<News_galerieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerieDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNews_galeries")
public ResponseEntity<List<News_galerieDto>> getNews_galerie( ) {
	List<News_galerie> lab=objetRepo.findAll();
	List<News_galerieDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<News_galerieDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addNews_galerie")
public ResponseEntity<News_galerieDto> addNews_galerie(@RequestBody News_galerieDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		News_galerie ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<News_galerieDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<News_galerieDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNews_galerie/{id}")
public ResponseEntity<News_galerieDto> updateNews_galerie(@PathVariable int id,@RequestBody News_galerieDto dto) {
	if(objetRepo.existsById(id)) {
		News_galerie ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<News_galerieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerieDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNews_galerie/{id}")
public ResponseEntity<News_galerieDto> deleteNews_galerie(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		News_galerie ab=objetRepo.deleteById(id);
		News_galerieDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<News_galerieDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<News_galerieDto>(HttpStatus.NOT_FOUND);
}


}
