package chan.springframework.petclinic.bootstrap;

import chan.springframework.petclinic.model.*;
import chan.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService; // Referencing them by the interface, so this is going to allow spring to
    // go ahead and inject it based on the active profile and check in one of the implementations based on the active profile.

    // any implementation of this interface that's in the spring context is going to get autowired. '@Autowired' not required
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Huskey");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Wild Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Nanda");
        owner1.setLastName("Gopal");
        owner1.setAddress("123 Meenambakkam");
        owner1.setCity("Chennai");
        owner1.setTelephone("7845129865");

        Pet nandusPet = new Pet();
        nandusPet.setPetType(savedDogPetType);
        nandusPet.setOwner(owner1);
        nandusPet.setBirthDate(LocalDate.now());
        nandusPet.setName("Bomb Babu");
        owner1.getPets().add(nandusPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Uber");
        owner2.setLastName("Chan");
        owner1.setAddress("654 T Nagar");
        owner1.setCity("Trichy");
        owner1.setTelephone("3265987845");

        Pet ubersCat = new Pet();
        ubersCat.setName("Kitty");
        ubersCat.setOwner(owner2);
        ubersCat.setBirthDate(LocalDate.now());
        ubersCat.setPetType(savedCatPetType);
        owner2.getPets().add(ubersCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(ubersCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Jumping cat");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mick");
        vet2.setLastName("Gorden");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
