package se.lexicon.pet_clinic.service;

import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.exception.DataNotFoundException;

import java.util.List;

public interface PetService {

    PetDto save(PetDto dto);

    PetDto update(PetDto dto) throws DataNotFoundException;

    void deleteById(String id);

    List<PetDto> findAll();

    PetDto findByID(String id) throws DataNotFoundException;

    PetDto findByName(String name);

    PetDto findByOwnerFirstNameAndLastName(String firstName , String LastName);

    PetDto findByOwnerTelephone(String telephone);


}
