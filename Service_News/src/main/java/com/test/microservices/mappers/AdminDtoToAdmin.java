package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.AdminDto;
import com.test.microservices.pojos.Admin;
@Service
public class AdminDtoToAdmin implements DtoToObject<AdminDto,Admin> {
	DozerBeanMapper modelMapper;
	@Override
	public Admin dtoToObject(AdminDto adminDto) {
		this.modelMapper= new DozerBeanMapper();
		Admin admin=modelMapper.map(adminDto, Admin.class);
		return admin;
	}

	@Override
	public AdminDto objectToDto(Admin admin) {
		this.modelMapper= new DozerBeanMapper();
		AdminDto adminDto=modelMapper.map(admin, AdminDto.class);
		return adminDto;
	}


	@Override
	public List<AdminDto> objectsToDtos(List<Admin> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<AdminDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(admin -> dtoList.add(modelMapper.map(admin, AdminDto.class)));
		return dtoList;
	}



	

}
