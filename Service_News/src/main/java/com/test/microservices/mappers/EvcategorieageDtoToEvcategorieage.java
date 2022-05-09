package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.EvcategorieageDto;
import com.test.microservices.pojos.Evcategorieage;
@Service
public class EvcategorieageDtoToEvcategorieage implements DtoToObject<EvcategorieageDto,Evcategorieage> {
	DozerBeanMapper modelMapper;
	@Override
	public Evcategorieage dtoToObject(EvcategorieageDto evcategorieageDto) {
		this.modelMapper= new DozerBeanMapper();
		Evcategorieage evcategorieage=modelMapper.map(evcategorieageDto, Evcategorieage.class);
		return evcategorieage;
	}

	@Override
	public EvcategorieageDto objectToDto(Evcategorieage evcategorieage) {
		this.modelMapper= new DozerBeanMapper();
		EvcategorieageDto evcategorieageDto=modelMapper.map(evcategorieage, EvcategorieageDto.class);
		return evcategorieageDto;
	}


	@Override
	public List<EvcategorieageDto> objectsToDtos(List<Evcategorieage> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<EvcategorieageDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(evcategorieage -> dtoList.add(modelMapper.map(evcategorieage, EvcategorieageDto.class)));
		return dtoList;
	}



	

}
