package se.lexicon.pet_clinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.PetType;

import java.util.List;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {

    List<PetType> findByName(String name);
}
