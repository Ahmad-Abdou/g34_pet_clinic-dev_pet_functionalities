package se.lexicon.pet_clinic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.service.PetService;
import java.util.List;


@RestController
@RequestMapping("/api/pet")
public class PetController {

    PetService petService;

    @Autowired
    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> findById(@PathVariable("id") String id){
        try {
            PetDto petDto = petService.findByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(petDto);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping
    public ResponseEntity<List<PetDto>> getAll(){
        List<PetDto> petDtoList = petService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(petDtoList);
    }
    @GetMapping("/owner")
    public ResponseEntity<PetDto> findByOwnerNameAndLastName(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName){
        PetDto petDto = petService.findByOwnerFirstNameAndLastName(firstName,lastName);
        return ResponseEntity.status(HttpStatus.OK).body(petDto);

    }
    @GetMapping("/telephone")
    public ResponseEntity<PetDto> findByOwnerTelephone(String telephone){
        PetDto petDto = petService.findByOwnerTelephone(telephone);
        return ResponseEntity.status(HttpStatus.OK).body(petDto);
    }

    @PostMapping
    public ResponseEntity<PetDto> save(@RequestBody PetDto petDto){
        PetDto petDto1 = petService.save(petDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(petDto1);
    }
    @PutMapping
    public  ResponseEntity<PetDto> update(PetDto petDto){
        PetDto petDto1 = petService.update(petDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(petDto1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")String id){
         petService.deleteById(id);
         return ResponseEntity.status(HttpStatus.OK).build();
    }


}
