package se.lexicon.pet_clinic.service;


import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.exception.DataNotFoundException;

import java.util.List;

public interface PetTypeService {

    PetTypeDto save(PetTypeDto dto);

    PetTypeDto findById(int id) throws DataNotFoundException;

    List<PetTypeDto> getAll();

    List<PetTypeDto> findByName(String name);

    void deleteById(int id);
}
