package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.NewscategorieDto;
import com.test.microservices.pojos.Newscategorie;
@Service
public class NewscategorieDtoToNewscategorie implements DtoToObject<NewscategorieDto,Newscategorie> {
	DozerBeanMapper modelMapper;
	@Override
	public Newscategorie dtoToObject(NewscategorieDto newscategorieDto) {
		this.modelMapper= new DozerBeanMapper();
		Newscategorie newscategorie=modelMapper.map(newscategorieDto, Newscategorie.class);
		return newscategorie;
	}

	@Override
	public NewscategorieDto objectToDto(Newscategorie newscategorie) {
		this.modelMapper= new DozerBeanMapper();
		NewscategorieDto newscategorieDto=modelMapper.map(newscategorie, NewscategorieDto.class);
		return newscategorieDto;
	}


	@Override
	public List<NewscategorieDto> objectsToDtos(List<Newscategorie> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<NewscategorieDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(newscategorie -> dtoList.add(modelMapper.map(newscategorie, NewscategorieDto.class)));
		return dtoList;
	}



	

}
