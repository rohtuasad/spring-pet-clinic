package ru.rohtuasad.springpetclinic.services;

import ru.rohtuasad.springpetclinic.model.Vet;

import java.time.LocalDate;
import java.util.Set;

public interface VetService {
    Vet findById(long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
