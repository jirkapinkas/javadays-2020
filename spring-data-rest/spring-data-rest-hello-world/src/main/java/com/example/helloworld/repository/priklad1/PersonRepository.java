package com.example.helloworld.repository.priklad1;

import com.example.helloworld.entity.priklad1.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
