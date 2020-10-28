package com.example.helloworld.repository.priklad1;

import com.example.helloworld.entity.priklad1.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "pets", path = "pets")
public interface DogRepository extends JpaRepository<Dog, Long> {
}
