package ru.rohtuasad.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.rohtuasad.springpetclinic.model.Owner;
import ru.rohtuasad.springpetclinic.model.Pet;
import ru.rohtuasad.springpetclinic.model.PetType;
import ru.rohtuasad.springpetclinic.model.Vet;
import ru.rohtuasad.springpetclinic.services.OwnerService;
import ru.rohtuasad.springpetclinic.services.PetTypeService;
import ru.rohtuasad.springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Backer st.");
        owner1.setCity("London");
        owner1.setTelephone("31415927");

        Pet mikesPet = new Pet();
        mikesPet.setOwner(owner1);
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setBirthday(LocalDate.now());
        mikesPet.setName("Wilfred");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Backer st.");
        owner2.setCity("London");
        owner2.setTelephone("31415927");

        Pet fionasCat = new Pet();
        fionasCat.setOwner(owner2);
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthday(LocalDate.now());
        fionasCat.setName("Garfield");
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dean");
        vet2.setLastName("Winchester");
        vetService.save(vet2);

        System.out.println("Loaded vets");
    }
}
