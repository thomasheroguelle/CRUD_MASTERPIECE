package com.masterpiecebrouillon.brouillon.repository;

import com.masterpiecebrouillon.brouillon.model.ApartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApartmentRepository extends JpaRepository<ApartmentModel, Long > {
    public List<ApartmentModel> findAll();
}
