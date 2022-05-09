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

import com.test.microservices.dto.CommentaireDto;
import com.test.microservices.mappers.CommentaireDtoToCommentaire;
import com.test.microservices.pojos.Commentaire;
import com.test.microservices.repositories.CommentaireRepository;
@RestController
public class CommentaireController {
	CommentaireDtoToCommentaire mapper;
	CommentaireRepository commentaireRepo;
	public CommentaireController(CommentaireRepository repo,CommentaireDtoToCommentaire m) {
		this.commentaireRepo=repo;
		this.mapper=m;
		// TODO Auto-generated constructor stub
	}
@GetMapping("/getCommentaireByIdMongo/{id}")
public ResponseEntity<CommentaireDto> getCommentaire( @PathVariable String id) {
	if(commentaireRepo.existsByIdMongo(id)) {
		Commentaire ab=commentaireRepo.findByIdMongo( id);
		CommentaireDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<CommentaireDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<CommentaireDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getCommentaireById/{id}")
public ResponseEntity<CommentaireDto> getCommentaire( @PathVariable int id) {
	if(commentaireRepo.existsById(id)) {
		Commentaire ab=commentaireRepo.findById( id);
		CommentaireDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<CommentaireDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<CommentaireDto>(HttpStatus.NOT_FOUND);
}
@GetMapping("/getAllCommentaires")
public ResponseEntity<List<CommentaireDto>> getCommentaire( ) {
	List<Commentaire> lab=commentaireRepo.findAll();
	List<CommentaireDto> ldto=mapper.objectsToDtos(lab);
	return new ResponseEntity<List<CommentaireDto>>(ldto,HttpStatus.OK);
}
@PostMapping("/addCommentaire")
public ResponseEntity<CommentaireDto> addCommentaire(@RequestBody CommentaireDto dto) {
	if(!commentaireRepo.existsById(dto.getId())) {
		Commentaire ab=mapper.dtoToObject(dto);
		commentaireRepo.save(ab);
		return new ResponseEntity<CommentaireDto>(dto,HttpStatus.CREATED);
	}
	return new ResponseEntity<CommentaireDto>(HttpStatus.CONFLICT);
}
@PutMapping("/updateCommentaire/{id}")
public ResponseEntity<CommentaireDto> updateCommentaire(@PathVariable int id,@RequestBody CommentaireDto dto) {
	if(commentaireRepo.existsById(id)) {
		Commentaire ab=mapper.dtoToObject(dto);
		commentaireRepo.save(ab);
		return new ResponseEntity<CommentaireDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<CommentaireDto>(HttpStatus.NOT_FOUND);
}
@DeleteMapping("/deleteCommentaire/{id}")
public ResponseEntity<CommentaireDto> deleteCommentaire(@PathVariable int id) {
	if(commentaireRepo.existsById(id)) {
		Commentaire ab=commentaireRepo.deleteById(id);
		CommentaireDto dto=mapper.objectToDto(ab);
		return new ResponseEntity<CommentaireDto>(dto,HttpStatus.OK);
	}
	return new ResponseEntity<CommentaireDto>(HttpStatus.NOT_FOUND);
}



}
