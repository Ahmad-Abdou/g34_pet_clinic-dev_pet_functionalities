package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetDto;
import se.lexicon.pet_clinic.entity.Owner;
import se.lexicon.pet_clinic.entity.Pet;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService{

    PetRepository petRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PetDto save(PetDto dto) {
       Pet entity = petRepository.save(modelMapper.map(dto, Pet.class));
        PetDto petDto = modelMapper.map(entity,PetDto.class);
        return petDto;
    }

    @Override
    public PetDto update(PetDto dto) {
        Pet pet = petRepository.save(modelMapper.map(dto,Pet.class));
        PetDto petDto = modelMapper.map(pet,PetDto.class);
        return petDto;
    }

    @Override
    public void deleteById(String id) {
        if(petRepository.findById(id).isPresent()){
            petRepository.deleteById(id);
        }
    }

    @Override
    public List<PetDto> findAll() {
        List<Pet> pets= new ArrayList<>();
        petRepository.findAll().iterator().forEachRemaining(pets::add);
        List<PetDto> petDtoList = pets.stream().map(pet -> modelMapper.map(pet,PetDto.class)).collect(Collectors.toList());
        return petDtoList;
    }

    @Override
    public PetDto findByID(String id) throws DataNotFoundException {
        Optional<Pet> pet = petRepository.findById(id);

        if(pet.isPresent()){
            PetDto petDto = modelMapper.map(pet.get(),PetDto.class);
            return petDto;
        }

        else throw new DataNotFoundException("Data not found");
    }

    @Override
    public PetDto findByName(String name) {
      Pet pet =  petRepository.findByNameIgnoreCase(name);
      PetDto petDto = modelMapper.map(pet,PetDto.class);
        return petDto;
    }

    @Override
    public PetDto findByOwnerFirstNameAndLastName(String firstName , String LastName) {
        Pet pet = petRepository.findByOwner_FirstNameAndOwnerLastName(firstName,LastName);
        PetDto petDto =modelMapper.map(pet,PetDto.class);
        return petDto;
    }

    @Override
    public PetDto findByOwnerTelephone(String telephone) {
        Pet pet = petRepository.findByOwnerTelephone(telephone);
        PetDto petDto = modelMapper.map(pet,PetDto.class);
        return petDto;
    }

}
