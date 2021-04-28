package se.lexicon.pet_clinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Visit;

public interface VisitRepository extends CrudRepository<Visit,String> {

    Visit findByPetName(String petName);

    Visit findByPetTypeName(String petTypeName);


}

