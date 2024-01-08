package com.masterpiecebrouillon.brouillon.repository.apartment;

import com.masterpiecebrouillon.brouillon.model.apartment.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<ApartmentModel, Long > {
    public List<ApartmentModel> findAll();
}
