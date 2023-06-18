package com.khanduja.techwonders.generics.services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GenericService<E, K> {
    E save(E entity);

    List<E> findAll();

    ResponseEntity<E> findById(K id);

    ResponseEntity<E> update(K id, E entity);

    ResponseEntity<String> delete(K id);

    <L> ResponseEntity<String> updatePartially(K id, Map<String, Object> fields, Class<L> aClass);
}
