package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvresultatDto;
import com.test.microservices.pojos.Evresultat;
@Service
public class EvresultatDtoToEvresultat implements DtoToObject<EvresultatDto,Evresultat> {
	DozerBeanMapper modelMapper;
	@Override
	public Evresultat dtoToObject(EvresultatDto evresultatDto) {
		this.modelMapper= new DozerBeanMapper();
		Evresultat evresultat=modelMapper.map(evresultatDto, Evresultat.class);
		return evresultat;
	}

	@Override
	public EvresultatDto objectToDto(Evresultat evresultat) {
		this.modelMapper= new DozerBeanMapper();
		EvresultatDto evresultatDto=modelMapper.map(evresultat, EvresultatDto.class);
		return evresultatDto;
	}


	@Override
	public List<EvresultatDto> objectsToDtos(List<Evresultat> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvresultatDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evresultat -> dtoList.add(modelMapper.map(evresultat, EvresultatDto.class)));
		return dtoList;
	}



	

}
