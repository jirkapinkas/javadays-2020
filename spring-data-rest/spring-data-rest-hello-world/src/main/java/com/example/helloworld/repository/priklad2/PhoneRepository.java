package com.example.helloworld.repository.priklad2;

import com.example.helloworld.entity.priklad2.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
