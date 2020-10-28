package com.example.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * High level Repository (extends JpaRepository)
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface SpringDataRestJpaRepository<T, ID> extends SpringDataRestRepository<T, ID>, JpaRepository<T, ID> {

}
