package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.ChampionDto;
import com.test.microservices.pojos.Champion;
@Service
public class ChampionDtoToChampion implements DtoToObject<ChampionDto,Champion> {
	DozerBeanMapper modelMapper;
	@Override
	public Champion dtoToObject(ChampionDto championDto) {
		this.modelMapper= new DozerBeanMapper();
		Champion champion=modelMapper.map(championDto, Champion.class);
		return champion;
	}

	@Override
	public ChampionDto objectToDto(Champion champion) {
		this.modelMapper= new DozerBeanMapper();
		ChampionDto championDto=modelMapper.map(champion, ChampionDto.class);
		return championDto;
	}


	@Override
	public List<ChampionDto> objectsToDtos(List<Champion> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<ChampionDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(champion -> dtoList.add(modelMapper.map(champion, ChampionDto.class)));
		return dtoList;
	}



	

}
