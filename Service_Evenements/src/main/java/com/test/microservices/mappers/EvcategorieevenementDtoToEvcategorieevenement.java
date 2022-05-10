package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvcategorieevenementDto;
import com.test.microservices.pojos.Evcategorieevenement;
@Service
public class EvcategorieevenementDtoToEvcategorieevenement implements DtoToObject<EvcategorieevenementDto,Evcategorieevenement> {
	DozerBeanMapper modelMapper;
	@Override
	public Evcategorieevenement dtoToObject(EvcategorieevenementDto evcategorieevenementDto) {
		this.modelMapper= new DozerBeanMapper();
		Evcategorieevenement evcategorieevenement=modelMapper.map(evcategorieevenementDto, Evcategorieevenement.class);
		return evcategorieevenement;
	}

	@Override
	public EvcategorieevenementDto objectToDto(Evcategorieevenement evcategorieevenement) {
		this.modelMapper= new DozerBeanMapper();
		EvcategorieevenementDto evcategorieevenementDto=modelMapper.map(evcategorieevenement, EvcategorieevenementDto.class);
		return evcategorieevenementDto;
	}


	@Override
	public List<EvcategorieevenementDto> objectsToDtos(List<Evcategorieevenement> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvcategorieevenementDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evcategorieevenement -> dtoList.add(modelMapper.map(evcategorieevenement, EvcategorieevenementDto.class)));
		return dtoList;
	}



	

}
