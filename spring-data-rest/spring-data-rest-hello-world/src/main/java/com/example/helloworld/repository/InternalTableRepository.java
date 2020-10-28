package com.example.helloworld.repository;

import com.example.helloworld.entity.InternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface InternalTableRepository extends JpaRepository<InternalTable, Long> {
}
