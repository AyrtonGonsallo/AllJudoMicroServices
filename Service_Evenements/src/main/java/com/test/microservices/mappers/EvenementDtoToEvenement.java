package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvenementDto;
import com.test.microservices.pojos.Evenement;
@Service
public class EvenementDtoToEvenement implements DtoToObject<EvenementDto,Evenement> {
	DozerBeanMapper modelMapper;
	@Override
	public Evenement dtoToObject(EvenementDto evenementDto) {
		this.modelMapper= new DozerBeanMapper();
		Evenement evenement=modelMapper.map(evenementDto, Evenement.class);
		return evenement;
	}

	@Override
	public EvenementDto objectToDto(Evenement evenement) {
		this.modelMapper= new DozerBeanMapper();
		EvenementDto evenementDto=modelMapper.map(evenement, EvenementDto.class);
		return evenementDto;
	}


	@Override
	public List<EvenementDto> objectsToDtos(List<Evenement> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvenementDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evenement -> dtoList.add(modelMapper.map(evenement, EvenementDto.class)));
		return dtoList;
	}



	

}
