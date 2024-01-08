package com.masterpiecebrouillon.brouillon.controller;

import com.masterpiecebrouillon.brouillon.mapper.AppartmentMapper;
import com.masterpiecebrouillon.brouillon.model.ApartmentModel;
import com.masterpiecebrouillon.brouillon.model.ApartmentModelDto;
import com.masterpiecebrouillon.brouillon.repository.ApartmentRepository;
import com.masterpiecebrouillon.brouillon.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appt")
@CrossOrigin(origins = "http://localhost:4200")
public class ApartmentController {

    @Autowired
    private AppartementService appartementService;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @GetMapping
    public ResponseEntity<List<ApartmentModel>> getAppartements() {
        return ResponseEntity.ok(appartementService.getAppartements());
    }

    @PostMapping("/create")
    public ResponseEntity<ApartmentModelDto> createAppartement(@RequestBody ApartmentModel apartmentModel) {
        ApartmentModel createdAppartement = appartementService.createNewAppartement(apartmentModel);
        ApartmentModelDto createdAppartementDTO = AppartmentMapper.INSTANCE.convertDTO(createdAppartement);
        return ResponseEntity.status(HttpStatus.CREATED).body((createdAppartementDTO));
    }

    @GetMapping("/appt/{id}")
    public ResponseEntity<ApartmentModel> getApptById(@PathVariable Long id) {
        ApartmentModel apartmentModel = appartementService.getAppartementById(id);
        if (apartmentModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(apartmentModel);
    }

//    @PutMapping("/{appartement_id}")
//    public ResponseEntity<AppartementModelDTO> updateAppartement(@PathVariable("appartement_id") Long appartementId, @RequestBody AppartementModel appartementModel) {
//        appartementModel.setId(appartementId);
//        AppartementModel updatedAppartement = appartementService.updateAppartement(appartementModel);
//        AppartementModelDTO appartementModelDTO = AppartementMapper.INSTANCE.convertDTO(updatedAppartement);
//        return ResponseEntity.ok((appartementModelDTO));
//    }
//    @DeleteMapping("/{appartement_id}")
//    public ResponseEntity<Boolean> deleteAppartement(@PathVariable("appartement_id") Long appartementId) {
//        if(appartementRepository.existsById(appartementId)) {
//            appartementService.deleteAppartement(appartementId);
//            return ResponseEntity.ok(true);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
