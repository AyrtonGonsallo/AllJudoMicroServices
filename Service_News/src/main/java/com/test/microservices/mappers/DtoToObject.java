package com.test.microservices.mappers;

import java.util.List;

public interface DtoToObject<Dto,Obj> {
	Obj  dtoToObject(Dto dto);
    Dto  objectToDto(Obj obj);
    List<Dto> objectsToDtos(List<Obj>  dtoList);
}
