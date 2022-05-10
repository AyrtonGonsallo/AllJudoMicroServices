package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvenementimportantsDto;
import com.test.microservices.pojos.Evenementimportant;
@Service
public class EvenementimportantsDtoToEvenementimportants implements DtoToObject<EvenementimportantsDto,Evenementimportant> {
	DozerBeanMapper modelMapper;
	@Override
	public Evenementimportant dtoToObject(EvenementimportantsDto evenementimportantsDto) {
		this.modelMapper= new DozerBeanMapper();
		Evenementimportant evenementimportants=modelMapper.map(evenementimportantsDto, Evenementimportant.class);
		return evenementimportants;
	}

	@Override
	public EvenementimportantsDto objectToDto(Evenementimportant evenementimportants) {
		this.modelMapper= new DozerBeanMapper();
		EvenementimportantsDto evenementimportantsDto=modelMapper.map(evenementimportants, EvenementimportantsDto.class);
		return evenementimportantsDto;
	}


	@Override
	public List<EvenementimportantsDto> objectsToDtos(List<Evenementimportant> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvenementimportantsDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evenementimportants -> dtoList.add(modelMapper.map(evenementimportants, EvenementimportantsDto.class)));
		return dtoList;
	}



	

}
