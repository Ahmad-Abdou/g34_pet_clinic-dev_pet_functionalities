package se.lexicon.pet_clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.service.PetTypeService;
import java.util.List;

@RestController
@RequestMapping("/api/pet/type")
public class PetTypeController {

    PetTypeService petTypeService;
    @Autowired
    public void setPetTypeService(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetTypeDto> findById(@PathVariable("id") int id){
        try {
            PetTypeDto petTypeDto =   petTypeService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(petTypeDto);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/name")
    public ResponseEntity<List<PetTypeDto>> findByName(@RequestParam String name){
        List<PetTypeDto> petTypeDto =  petTypeService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(petTypeDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id){
        petTypeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping
    public ResponseEntity<PetTypeDto> update(@RequestBody PetTypeDto dto){
        PetTypeDto petTypeDto = petTypeService.save(dto);
        return ResponseEntity.status(HttpStatus.OK).body(petTypeDto);
    }
    @GetMapping
    public ResponseEntity<List<PetTypeDto>> getAll(){
        List<PetTypeDto> petTypeDtos = petTypeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(petTypeDtos);
    }

    @PostMapping
    public ResponseEntity<PetTypeDto> save(@RequestBody PetTypeDto dto){
        PetTypeDto petTypeDto = petTypeService.save(dto);
        System.out.println(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(petTypeDto);

    }






}
