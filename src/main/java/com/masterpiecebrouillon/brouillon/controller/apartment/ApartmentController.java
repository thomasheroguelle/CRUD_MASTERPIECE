package com.masterpiecebrouillon.brouillon.controller.apartment;

import com.masterpiecebrouillon.brouillon.model.apartment.ApartmentModel;
import com.masterpiecebrouillon.brouillon.repository.apartment.ApartmentRepository;
import com.masterpiecebrouillon.brouillon.service.apartment.ApartmentService;
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
    private ApartmentService apartmentService;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @GetMapping
    public ResponseEntity<List<ApartmentModel>> getApartments() {
        List<ApartmentModel> getAppartmentsList = apartmentService.getApartments();
        return new ResponseEntity<>(getAppartmentsList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApartmentModel> createApartment(@RequestBody ApartmentModel apartmentModel) {
        ApartmentModel createdApt = apartmentService.createNewApartment(apartmentModel);
        return new ResponseEntity<>(createdApt, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApartmentModel> getApartmentById(@PathVariable Long id) {
        ApartmentModel aptId = apartmentService.getApartmentById(id);
        if (aptId == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(aptId, HttpStatus.OK);
    }

}
