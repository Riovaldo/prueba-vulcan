package bo.vulcan.service.impl;

import bo.vulcan.repository.Repository;
import bo.vulcan.service.IServiceCRUD;
import bo.vulcan.utils.exception.NotFoundException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

public class ServiceCRUD<E> implements IServiceCRUD<E> {

    @Inject
    Repository<E> repository;


    @Override
    public E findById(Long id) {
        return this.repository.findByIdOptional(id).orElseThrow(
                () -> new NotFoundException("El recurso no pudo ser encontrado."));
    }

    @Override
    public List<E> findAll() {
        return this.repository.listAll();
    }

    @Override
    @Transactional
    public E save(E entity) {
        this.repository.persist(entity);
        return entity;
    }

    @Override
    public void update(E entity) {
        this.repository.persist(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
