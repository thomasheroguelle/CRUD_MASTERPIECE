package com.masterpiecebrouillon.brouillon.service.apartment;

import com.masterpiecebrouillon.brouillon.model.apartment.ApartmentModel;
import com.masterpiecebrouillon.brouillon.repository.apartment.ApartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {
    @Autowired
    private ApartmentRepository apartmentRepository;

    public ApartmentModel createNewApartment(ApartmentModel apartmentModel) {
        return apartmentRepository.save(apartmentModel);
    }

    public List<ApartmentModel> getApartments() {
        return apartmentRepository.findAll();
    }

    public ApartmentModel getApartmentById(Long id) {
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
