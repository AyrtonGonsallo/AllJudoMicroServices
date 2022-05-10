package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.ClubDto;
import com.test.microservices.pojos.Club;
@Service
public class ClubDtoToClub implements DtoToObject<ClubDto,Club> {
	DozerBeanMapper modelMapper;
	@Override
	public Club dtoToObject(ClubDto clubDto) {
		this.modelMapper= new DozerBeanMapper();
		Club club=modelMapper.map(clubDto, Club.class);
		return club;
	}

	@Override
	public ClubDto objectToDto(Club club) {
		this.modelMapper= new DozerBeanMapper();
		ClubDto clubDto=modelMapper.map(club, ClubDto.class);
		return clubDto;
	}


	@Override
	public List<ClubDto> objectsToDtos(List<Club> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<ClubDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(club -> dtoList.add(modelMapper.map(club, ClubDto.class)));
		return dtoList;
	}



	

}
