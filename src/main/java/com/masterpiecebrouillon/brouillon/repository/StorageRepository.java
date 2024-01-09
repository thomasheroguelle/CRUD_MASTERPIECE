package com.masterpiecebrouillon.brouillon.repository;

import com.masterpiecebrouillon.brouillon.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
    Optional<ImageData> findByName(String fileName);

}
