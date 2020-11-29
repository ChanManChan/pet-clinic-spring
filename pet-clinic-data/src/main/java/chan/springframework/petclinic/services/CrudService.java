package chan.springframework.petclinic.services;

import java.util.Set;

// mimicking the spring data repository
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);

    void delete(T object);
    void deleteById(ID id);
}
