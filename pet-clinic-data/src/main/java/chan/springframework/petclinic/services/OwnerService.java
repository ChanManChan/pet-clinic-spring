package chan.springframework.petclinic.services;

import chan.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
