package com.masterpiecebrouillon.brouillon.service;

import com.masterpiecebrouillon.brouillon.model.AppartementModel;
import com.masterpiecebrouillon.brouillon.repository.AppartementRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppartementService {
    @Autowired
    private AppartementRepository appartementRepository;

    public AppartementModel createNewAppartement(AppartementModel appartementModel) {
        return appartementRepository.save(appartementModel);
    }
    public List<AppartementModel> getAppartements() {
        return appartementRepository.findAll();
    }
    public AppartementModel updateAppartement(AppartementModel appartementModel) {
        boolean appartementExists = this.appartementRepository.existsById(appartementModel.getId());
        if(!appartementExists) {
            throw new EntityNotFoundException("Appartement with ID " + appartementModel.getId() + " not found");
        }
        return appartementRepository.save(appartementModel);
    }
    public void deleteAppartement(Integer id) {
        if(appartementRepository.existsById(id)) {
            appartementRepository.deleteById(id);
        }
    }
}
