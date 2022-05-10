package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvequipeDto;
import com.test.microservices.pojos.Evequipe;
@Service
public class EvequipeDtoToEvequipe implements DtoToObject<EvequipeDto,Evequipe> {
	DozerBeanMapper modelMapper;
	@Override
	public Evequipe dtoToObject(EvequipeDto evequipeDto) {
		this.modelMapper= new DozerBeanMapper();
		Evequipe evequipe=modelMapper.map(evequipeDto, Evequipe.class);
		return evequipe;
	}

	@Override
	public EvequipeDto objectToDto(Evequipe evequipe) {
		this.modelMapper= new DozerBeanMapper();
		EvequipeDto evequipeDto=modelMapper.map(evequipe, EvequipeDto.class);
		return evequipeDto;
	}


	@Override
	public List<EvequipeDto> objectsToDtos(List<Evequipe> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvequipeDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evequipe -> dtoList.add(modelMapper.map(evequipe, EvequipeDto.class)));
		return dtoList;
	}



	

}
