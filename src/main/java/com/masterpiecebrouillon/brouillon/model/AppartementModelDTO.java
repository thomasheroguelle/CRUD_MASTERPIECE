package com.masterpiecebrouillon.brouillon.model;

import lombok.Data;

@Data
public class AppartementModelDTO {
    private int id;
    private String title;
    private String description;
    private double price;
}
