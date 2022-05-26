package com.tomboy.SpringBoot.LearnTour.Respository;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mech")
                .departmentAddress("Munabi")
                .departmentCode("mU007")
                .build();

        entityManager.persist(department);

    }

    @Test
    @DisplayName("Validate departmentRepository by ID")
    public void whenFindById_thenReturnDepartment()
    {
         Department department = departmentRepository.findById(1l).get();

         assertEquals(department.getDepartmentName(),"Mech");
    }


}