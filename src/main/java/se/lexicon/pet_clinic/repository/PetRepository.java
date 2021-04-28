package se.lexicon.pet_clinic.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.entity.PetType;

public interface PetRepository extends CrudRepository<Pet,String> {

    Pet findByNameIgnoreCase(String name);
    Pet findByPetTypeName(PetType petType);
    Pet findByOwner(Owner owner);
    Pet findByOwnerTelephoneNumber(Owner owner);

}
