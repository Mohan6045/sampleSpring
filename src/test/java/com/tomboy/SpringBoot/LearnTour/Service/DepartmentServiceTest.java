package com.tomboy.SpringBoot.LearnTour.Service;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import com.tomboy.SpringBoot.LearnTour.Respository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    public DepartmentService departmentService;
    @MockBean
    public DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Chennai")
                .departmentCode("CH007")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Validate Department Service")
    public void whileValidDepartmentName_ThenDepartmentShouldFound()
    {
       String departmentName = "IT";
       Department Found = departmentService.findDepartmentByName(departmentName);

       assertEquals(departmentName,Found.getDepartmentName());
    }

}