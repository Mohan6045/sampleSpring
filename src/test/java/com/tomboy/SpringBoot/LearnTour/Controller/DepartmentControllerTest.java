package com.tomboy.SpringBoot.LearnTour.Controller;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import com.tomboy.SpringBoot.LearnTour.Error.DepartmentNotFoundExpection;
import com.tomboy.SpringBoot.LearnTour.Service.DepartmentService;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp()
    {
         department = Department.builder().departmentId(1L)
            .departmentName("IT")
            .departmentAddress("Chennai")
            .departmentCode("CH007")
            .build();
    }

    @Test
    void saveDepartment() throws Exception {

        Department inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("Chennai")
                .departmentCode("CH007")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"departmentName\": \"IT\",\n" +
                        "  \"departmentAddress\": \"Chennai\",\n" +
                        "  \"departmentCode\": \"CH007 \"\n" +
                        "\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {

        Mockito.when(departmentService.fetchDepartmentById(1l)).thenReturn(department);
        mockMvc.perform(MockMvcRequestBuilders.get("/departments").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
               // .andExpect(JsonPath(expression: "$.departmentName")).value(department.getDepartmentName());
    }
}