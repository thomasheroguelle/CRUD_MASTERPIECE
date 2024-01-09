package com.masterpiecebrouillon.brouillon.dto.apartment;

import lombok.Data;

@Data
public class ApartmentModelDto {
    private int id;
    private String address;
    private String description;
    private double price;
}
