package ru.rohtuasad.springpetclinic.services;

import ru.rohtuasad.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
