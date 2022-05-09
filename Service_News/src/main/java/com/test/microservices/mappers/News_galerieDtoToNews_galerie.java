package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.News_galerieDto;
import com.test.microservices.pojos.News_galerie;
@Service
public class News_galerieDtoToNews_galerie implements DtoToObject<News_galerieDto,News_galerie> {
	DozerBeanMapper modelMapper;
	@Override
	public News_galerie dtoToObject(News_galerieDto news_galerieDto) {
		this.modelMapper= new DozerBeanMapper();
		News_galerie news_galerie=modelMapper.map(news_galerieDto, News_galerie.class);
		return news_galerie;
	}

	@Override
	public News_galerieDto objectToDto(News_galerie news_galerie) {
		this.modelMapper= new DozerBeanMapper();
		News_galerieDto news_galerieDto=modelMapper.map(news_galerie, News_galerieDto.class);
		return news_galerieDto;
	}


	@Override
	public List<News_galerieDto> objectsToDtos(List<News_galerie> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<News_galerieDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(news_galerie -> dtoList.add(modelMapper.map(news_galerie, News_galerieDto.class)));
		return dtoList;
	}



	

}
