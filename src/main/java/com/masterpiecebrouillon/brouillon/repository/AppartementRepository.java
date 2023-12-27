package com.masterpiecebrouillon.brouillon.repository;

import com.masterpiecebrouillon.brouillon.model.AppartementModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppartementRepository extends JpaRepository<AppartementModel, Integer > {
    public List<AppartementModel> findAll();
}
