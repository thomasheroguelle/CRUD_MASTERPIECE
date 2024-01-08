package com.masterpiecebrouillon.brouillon.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "apartment")
public class ApartmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id", nullable = false)
    private Long id;
    @Column(name = "apartment_address", nullable = false)
    private String address;
    @Column(name = "apartment_description", nullable = false)
    private String description;
    @Column(name = "apartment_price", nullable = false)
    private double price;


}
