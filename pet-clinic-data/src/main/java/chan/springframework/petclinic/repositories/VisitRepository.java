package chan.springframework.petclinic.repositories;

import chan.springframework.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
