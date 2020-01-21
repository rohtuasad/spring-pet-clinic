package ru.rohtuasad.springpetclinic.services;

import ru.rohtuasad.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findbyId(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
