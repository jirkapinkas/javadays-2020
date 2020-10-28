package com.example.helloworld.repository.priklad2;

import com.example.helloworld.entity.priklad2.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(Employee.GRAPH_PHONE)
    @Override
    List<Employee> findAll();

    @EntityGraph(Employee.GRAPH_PHONE)
    @Override
    List<Employee> findAll(Sort sort);

    @EntityGraph(Employee.GRAPH_PHONE)
    @Override
    Page<Employee> findAll(Pageable pageable);
}
