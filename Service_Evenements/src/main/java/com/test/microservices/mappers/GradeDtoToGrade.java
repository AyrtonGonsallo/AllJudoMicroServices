package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.GradeDto;
import com.test.microservices.pojos.Grade;
@Service
public class GradeDtoToGrade implements DtoToObject<GradeDto,Grade> {
	DozerBeanMapper modelMapper;
	@Override
	public Grade dtoToObject(GradeDto gradeDto) {
		this.modelMapper= new DozerBeanMapper();
		Grade grade=modelMapper.map(gradeDto, Grade.class);
		return grade;
	}

	@Override
	public GradeDto objectToDto(Grade grade) {
		this.modelMapper= new DozerBeanMapper();
		GradeDto gradeDto=modelMapper.map(grade, GradeDto.class);
		return gradeDto;
	}


	@Override
	public List<GradeDto> objectsToDtos(List<Grade> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<GradeDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(grade -> dtoList.add(modelMapper.map(grade, GradeDto.class)));
		return dtoList;
	}



	

}
