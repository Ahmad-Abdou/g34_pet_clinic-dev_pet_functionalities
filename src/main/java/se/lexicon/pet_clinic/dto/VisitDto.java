package se.lexicon.pet_clinic.dto;

import se.lexicon.pet_clinic.entity.Pet;


import java.time.LocalDate;

public class VisitDto {
    private String id;
    private PetDto petDto;
    private LocalDate visitDate;
    private String description;
}
