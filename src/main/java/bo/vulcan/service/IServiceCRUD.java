package bo.vulcan.service;

import java.util.List;

public interface IServiceCRUD<E> {
    E findById(Long id);
    List<E> findAll();
    E save(E entity);
    void update(E entity);
    void deleteById(Long id);
}
