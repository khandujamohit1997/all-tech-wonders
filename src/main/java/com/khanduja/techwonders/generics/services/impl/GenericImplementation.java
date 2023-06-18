package com.khanduja.techwonders.generics.services.impl;

import com.khanduja.techwonders.generics.repository.GenericRepository;
import com.khanduja.techwonders.generics.services.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class GenericImplementation<E, K> implements GenericService<E, K> {

    private GenericRepository<E, K> genericRepository;

    public GenericImplementation(GenericRepository<E, K> genericRepository) {
        this.genericRepository = genericRepository;
    }

    public GenericImplementation() {
    }

    @Override
    public E save(E entity) {
        return genericRepository.save(entity);
    }

    @Override
    public List<E> findAll() {
        return genericRepository.findAll();
    }

    @Override
    public ResponseEntity<E> findById(K id) {
        // TODO: 07/06/23 Parameterized Queries and Prepared Statements
        Optional<E> optionalEntity = genericRepository.findById(id);
        return optionalEntity.map(e -> new ResponseEntity<>(e, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<E> update(K id, E entity) {
        Optional<E> optionalE = genericRepository.findById(id);
        return optionalE.map(e -> new ResponseEntity<>(genericRepository.save(entity), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<String> delete(K id) {
        Optional<E> optionalE = genericRepository.findById(id);
        if (optionalE.isPresent()) {
            genericRepository.delete(optionalE.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public <L> ResponseEntity<String> updatePartially(K id, Map<String, Object> fields, Class<L> aClass) {
        Optional<E> entityOptional = genericRepository.findById(id);
        if (entityOptional.isEmpty()) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        }
        E existingEntity = entityOptional.get();
        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(aClass, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingEntity, value);
                genericRepository.save(existingEntity);
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
