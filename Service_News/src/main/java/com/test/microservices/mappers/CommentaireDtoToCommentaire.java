package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.CommentaireDto;
import com.test.microservices.pojos.Commentaire;
@Service
public class CommentaireDtoToCommentaire implements DtoToObject<CommentaireDto,Commentaire> {
	DozerBeanMapper modelMapper;
	@Override
	public Commentaire dtoToObject(CommentaireDto commentaireDto) {
		this.modelMapper= new DozerBeanMapper();
		Commentaire commentaire=modelMapper.map(commentaireDto, Commentaire.class);
		return commentaire;
	}

	@Override
	public CommentaireDto objectToDto(Commentaire commentaire) {
		this.modelMapper= new DozerBeanMapper();
		CommentaireDto commentaireDto=modelMapper.map(commentaire, CommentaireDto.class);
		return commentaireDto;
	}


	@Override
	public List<CommentaireDto> objectsToDtos(List<Commentaire> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<CommentaireDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(commentaire -> dtoList.add(modelMapper.map(commentaire, CommentaireDto.class)));
		return dtoList;
	}



	

}
