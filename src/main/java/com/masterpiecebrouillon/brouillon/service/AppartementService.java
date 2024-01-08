package com.masterpiecebrouillon.brouillon.service;

import com.masterpiecebrouillon.brouillon.model.ApartmentModel;
import com.masterpiecebrouillon.brouillon.repository.ApartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartementService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public ApartmentModel createNewAppartement(ApartmentModel apartmentModel) {
        return apartmentRepository.save(apartmentModel);
    }

    public List<ApartmentModel> getAppartements() {
        return apartmentRepository.findAll();
    }

    public ApartmentModel getAppartementById(Long id) {
        Optional<ApartmentModel> optionalAppartement = apartmentRepository.findById(id);
        return optionalAppartement.orElse(null);
    }


    public ApartmentModel updateAppartement(ApartmentModel apartmentModel) {
        boolean appartementExists = this.apartmentRepository.existsById(apartmentModel.getId());
        if (!appartementExists) {
            throw new EntityNotFoundException("Appartement with ID " + apartmentModel.getId() + " not found");
        }
        return apartmentRepository.save(apartmentModel);
    }

    public void deleteAppartement(Long id) {
        if (apartmentRepository.existsById(id)) {
            apartmentRepository.deleteById(id);
        }
    }
}
