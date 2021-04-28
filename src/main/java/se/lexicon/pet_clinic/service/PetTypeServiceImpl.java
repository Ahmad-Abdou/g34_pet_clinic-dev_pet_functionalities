package se.lexicon.pet_clinic.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.pet_clinic.dto.PetTypeDto;
import se.lexicon.pet_clinic.entity.PetType;
import se.lexicon.pet_clinic.exception.DataNotFoundException;
import se.lexicon.pet_clinic.repository.PetTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PetTypeServiceImpl implements PetTypeService{

    PetTypeRepository petTypeRepository;
    ModelMapper modelMapper;

    @Autowired
    public void setPetTypeRepository(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PetTypeDto save(PetTypeDto dto) {
        PetType entity = petTypeRepository.save(modelMapper.map(dto,PetType.class));
        PetTypeDto petTypeDto = modelMapper.map(entity,PetTypeDto.class);

        return  petTypeDto;

    }

    @Override
    public PetTypeDto findById(int id) throws DataNotFoundException {
        Optional<PetType> entity = petTypeRepository.findById(id);
        if(entity.isPresent()){
            PetTypeDto petTypeDto = modelMapper.map(entity.get(),PetTypeDto.class);
            return petTypeDto;
        }
        else throw new DataNotFoundException("Data not found");
    }

    @Override
    public List<PetTypeDto> getAll() {
        List<PetType> petType = new ArrayList<>();
        petTypeRepository.findAll().iterator().forEachRemaining(petType::add);
        List<PetTypeDto> dtoList = petType.stream().map(petType1 -> modelMapper.map(petType1,PetTypeDto.class)).collect(Collectors.toList());
        return dtoList;
    }
    @Override
    public List<PetTypeDto> findByName(String name) {
        List<PetType> petTypes= new ArrayList<>();
        petTypeRepository.findByName(name).iterator().forEachRemaining(petTypes::add);
        List <PetTypeDto> petTypeDto = petTypes.stream().map(petType -> modelMapper.map(petType,PetTypeDto.class)).collect(Collectors.toList());
        return petTypeDto;
    }

    @Override
    public void deleteById(int id) {
        Optional<PetType> petTypeDto =petTypeRepository.findById(id);
        if(petTypeDto.isPresent()){
            petTypeRepository.deleteById(id);
        }
    }
}