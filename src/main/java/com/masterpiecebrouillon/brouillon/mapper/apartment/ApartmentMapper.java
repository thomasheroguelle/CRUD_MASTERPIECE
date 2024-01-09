package com.masterpiecebrouillon.brouillon.mapper.apartment;

import com.masterpiecebrouillon.brouillon.model.apartment.ApartmentModel;
import com.masterpiecebrouillon.brouillon.dto.apartment.ApartmentModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ApartmentMapper {

    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);

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
