package com.test.microservices.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.test.microservices.dto.NewsDto;
import com.test.microservices.pojos.News;
@Service
public class NewsDtoToNews implements DtoToObject<NewsDto,News> {
	DozerBeanMapper modelMapper;
	@Override
	public News dtoToObject(NewsDto newsDto) {
		this.modelMapper= new DozerBeanMapper();
		News news=modelMapper.map(newsDto, News.class);
		return news;
	}

	@Override
	public NewsDto objectToDto(News news) {
		this.modelMapper= new DozerBeanMapper();
		NewsDto newsDto=modelMapper.map(news, NewsDto.class);
		return newsDto;
	}


	@Override
	public List<NewsDto> objectsToDtos(List<News> objectList) {
		this.modelMapper= new DozerBeanMapper();
		List<NewsDto>dtoList=new ArrayList<>();
		objectList.stream().forEach(news -> dtoList.add(modelMapper.map(news, NewsDto.class)));
		return dtoList;
	}



	

}
