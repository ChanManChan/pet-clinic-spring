package chan.springframework.petclinic.repositories;

import chan.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
