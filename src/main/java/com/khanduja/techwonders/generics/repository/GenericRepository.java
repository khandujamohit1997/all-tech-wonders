package com.khanduja.techwonders.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E, K> extends JpaRepository<E, K> {
}
