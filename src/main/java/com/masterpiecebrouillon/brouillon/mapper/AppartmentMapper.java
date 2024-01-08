package com.masterpiecebrouillon.brouillon.mapper;

import com.masterpiecebrouillon.brouillon.model.ApartmentModel;
import com.masterpiecebrouillon.brouillon.model.ApartmentModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AppartmentMapper {

    AppartmentMapper INSTANCE = Mappers.getMapper(AppartmentMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    ApartmentModelDto convertDTO(ApartmentModel apartmentModel);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    ApartmentModelDto convertDTO(ApartmentModelDto apartmentModelDto);

}
