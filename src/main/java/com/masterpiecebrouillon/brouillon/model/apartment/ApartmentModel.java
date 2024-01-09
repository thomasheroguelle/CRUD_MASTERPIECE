package com.masterpiecebrouillon.brouillon.model.apartment;

import com.masterpiecebrouillon.brouillon.model.image.ImageData;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<<HEAD:src/main/java/com/masterpiecebrouillon/brouillon/model/apartment/ApartmentModel.java
import jakarta.persistence.OneToMany;
=======
import jakarta.persistence.OneToOne;
>>>>>>>1dcc379256e964040799333448d0c5cc73f1a12f:src/main/java/com/masterpiecebrouillon/brouillon/model/ApartmentModel.java
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

<<<<<<<HEAD:src/main/java/com/masterpiecebrouillon/brouillon/model/apartment/ApartmentModel.java
import java.util.List;

=======
import java.awt.*;
>>>>>>>1dcc379256e964040799333448d0c5cc73f1a12f:src/main/java/com/masterpiecebrouillon/brouillon/model/ApartmentModel.java

@Getter
@Setter
@Entity
@Table(name = "apartment")
public class ApartmentModel {
    @Id // id qui s'auto incremente => on appelle ça les séquences
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id", nullable = false)
    private Long id;
    @Column(name = "apartment_address", nullable = false)
    private String address;
    @Column(name = "apartment_description", nullable = false)
    private String description;
    @Column(name = "apartment_price", nullable = false)
    private double price;
    @OneToMany(mappedBy = "apartmentModel", cascade = CascadeType.ALL)     // 1 apt pour plusieurs img
    private List<ImageData> imageList;
}
