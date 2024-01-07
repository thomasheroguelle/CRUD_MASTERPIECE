package com.masterpiecebrouillon.brouillon.controller;

import com.masterpiecebrouillon.brouillon.mapper.AppartementMapper;
import com.masterpiecebrouillon.brouillon.model.AppartementModel;
import com.masterpiecebrouillon.brouillon.model.AppartementModelDTO;
import com.masterpiecebrouillon.brouillon.repository.AppartementRepository;
import com.masterpiecebrouillon.brouillon.service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appt")
@CrossOrigin
public class AppartementController {

    @Autowired
    private AppartementService appartementService;
    @Autowired
    private AppartementRepository appartementRepository;

    @GetMapping
    public ResponseEntity<List<AppartementModel>> getAppartements() {
        return ResponseEntity.ok(appartementService.getAppartements());
    }

    @PostMapping("/create")
    public ResponseEntity<AppartementModelDTO> createAppartement(@RequestBody AppartementModel appartementModel) {
        AppartementModel createdAppartement = appartementService.createNewAppartement(appartementModel);
        AppartementModelDTO createdAppartementDTO = AppartementMapper.INSTANCE.convertDTO(createdAppartement);
        return ResponseEntity.status(HttpStatus.CREATED).body((createdAppartementDTO));
    }

    @GetMapping("/appt/{id}")
    public ResponseEntity<AppartementModel> getApptById(@PathVariable Long id) {
        AppartementModel appartementModel = appartementService.getAppartementById(id);
        if (appartementModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appartementModel);
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
