package ru.rohtuasad.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import ru.rohtuasad.springpetclinic.model.Owner;
import ru.rohtuasad.springpetclinic.model.Pet;
import ru.rohtuasad.springpetclinic.services.OwnerService;
import ru.rohtuasad.springpetclinic.services.PetService;
import ru.rohtuasad.springpetclinic.services.PetTypeService;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null) {
            return null;
        }
        if (owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                } else {
                    throw new RuntimeException("Pet type must be not null");
                }

                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }
        return super.save(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
