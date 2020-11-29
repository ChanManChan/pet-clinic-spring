package chan.springframework.petclinic.bootstrap;

import chan.springframework.petclinic.model.Owner;
import chan.springframework.petclinic.model.Vet;
import chan.springframework.petclinic.services.OwnerService;
import chan.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    // any implementation of this interface that's in the spring context is going to get autowired. '@Autowired' not required
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Nanda");
        owner1.setLastName("Gopal");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Uber");
        owner2.setLastName("Chan");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mick");
        vet2.setLastName("Gorden");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
