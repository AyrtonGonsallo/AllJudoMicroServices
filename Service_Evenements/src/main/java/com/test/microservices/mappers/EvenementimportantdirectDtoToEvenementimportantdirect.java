package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvenementimportantdirectDto;
import com.test.microservices.pojos.Evenementimportantdirect;
@Service
public class EvenementimportantdirectDtoToEvenementimportantdirect implements DtoToObject<EvenementimportantdirectDto,Evenementimportantdirect> {
	DozerBeanMapper modelMapper;
	@Override
	public Evenementimportantdirect dtoToObject(EvenementimportantdirectDto evenementimportantdirectDto) {
		this.modelMapper= new DozerBeanMapper();
		Evenementimportantdirect evenementimportantdirect=modelMapper.map(evenementimportantdirectDto, Evenementimportantdirect.class);
		return evenementimportantdirect;
	}

	@Override
	public EvenementimportantdirectDto objectToDto(Evenementimportantdirect evenementimportantdirect) {
		this.modelMapper= new DozerBeanMapper();
		EvenementimportantdirectDto evenementimportantdirectDto=modelMapper.map(evenementimportantdirect, EvenementimportantdirectDto.class);
		return evenementimportantdirectDto;
	}


	@Override
	public List<EvenementimportantdirectDto> objectsToDtos(List<Evenementimportantdirect> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvenementimportantdirectDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evenementimportantdirect -> dtoList.add(modelMapper.map(evenementimportantdirect, EvenementimportantdirectDto.class)));
		return dtoList;
	}



	

}
