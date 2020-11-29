package chan.springframework.petclinic.repositories;

import chan.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
