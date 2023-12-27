package com.masterpiecebrouillon.brouillon.mapper;

import com.masterpiecebrouillon.brouillon.model.AppartementModel;
import com.masterpiecebrouillon.brouillon.model.AppartementModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AppartementMapper {

    AppartementMapper INSTANCE = Mappers.getMapper(AppartementMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    AppartementModelDTO convertDTO(AppartementModel appartementModel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    AppartementModelDTO convertDTO(AppartementModelDTO appartementModelDTO);

}
