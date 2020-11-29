package chan.springframework.petclinic.repositories;

import chan.springframework.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
