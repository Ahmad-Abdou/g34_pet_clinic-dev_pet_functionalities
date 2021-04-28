package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

public interface PetRepository extends CrudRepository<Pet,String> {

    Pet findByNameIgnoreCase(String name);

    Pet findByPetType_NameIgnoreCase(String name);

    Pet findByOwner_FirstNameAndOwnerLastName(String firstName , String LastName);

    Pet findByOwnerTelephone(String telephone);

}
