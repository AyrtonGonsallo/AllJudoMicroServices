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

import com.test.microservices.dto.NewsDto;
import com.test.microservices.mappers.NewsDtoToNews;
import com.test.microservices.pojos.News;
import com.test.microservices.repositories.NewsRepository;
@RestController
public class NewsController {
	NewsDtoToNews mapper;
	NewsRepository objetRepo;
	public NewsController(NewsRepository repo,NewsDtoToNews m) {
		this.objetRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getNewsByIdMongo/{id}")
public ResponseEntity<NewsDto> getNews( @PathVariable String id) {
	if(objetRepo.existsByIdMongo(id)) {
		News ab=objetRepo.findByIdMongo( id);
		NewsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewsDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getNewsById/{id}")
public ResponseEntity<NewsDto> getNews( @PathVariable int id) {
	if(objetRepo.existsById(id)) {
		News ab=objetRepo.findById( id);
		NewsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewsDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllNewss")
public ResponseEntity<List<NewsDto>> getNews( ) {
	List<News> lab=objetRepo.findAll();
	List<NewsDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<NewsDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addNews")
public ResponseEntity<NewsDto> addNews(@RequestBody NewsDto dto) {
	if(!objetRepo.existsById(dto.getId())) {
		News ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<NewsDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<NewsDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateNews/{id}")
public ResponseEntity<NewsDto> updateNews(@PathVariable int id,@RequestBody NewsDto dto) {
	if(objetRepo.existsById(id)) {
		News ab=mapper.dtoToObject(dto);
		objetRepo.save(ab);
		return new ResponseEntity<NewsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewsDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteNews/{id}")
public ResponseEntity<NewsDto> deleteNews(@PathVariable int id) {
	if(objetRepo.existsById(id)) {
		News ab=objetRepo.deleteById(id);
		NewsDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<NewsDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<NewsDto>(HttpStatus.NOT_FOUND);
}


}
