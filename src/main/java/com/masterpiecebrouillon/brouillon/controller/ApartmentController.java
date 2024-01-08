package com.masterpiecebrouillon.brouillon.controller;

import com.masterpiecebrouillon.brouillon.model.ApartmentModel;
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
    public ResponseEntity<List<ApartmentModel>> getApartments() {
        List<ApartmentModel> getAppartmentsList = appartementService.getAppartements();
        return new ResponseEntity<>(getAppartmentsList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApartmentModel> createApartment(@RequestBody ApartmentModel apartmentModel) {
        ApartmentModel createdApt = appartementService.createNewAppartement(apartmentModel);
        return new ResponseEntity<>(createdApt, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentModel> getApartmentById(@PathVariable Long id) {
        ApartmentModel aptId = appartementService.getAppartementById(id);
        if (aptId == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(aptId, HttpStatus.OK);
    }

}
