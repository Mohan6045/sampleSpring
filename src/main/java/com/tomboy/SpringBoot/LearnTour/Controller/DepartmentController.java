package com.tomboy.SpringBoot.LearnTour.Controller;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import com.tomboy.SpringBoot.LearnTour.Error.DepartmentNotFoundExpection;
import com.tomboy.SpringBoot.LearnTour.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
     @Autowired
    private DepartmentService departmentService;

     public final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
   public Department saveDepartment(@Valid @RequestBody Department department)
   {
       log.info("Inside DepartmentController.class -> saveDepartment.method");
       return departmentService.saveDepartment(department);
   }

   @GetMapping("/departments")
   public List<Department> fetchDepartment()
   {
       log.info("Inside DepartmentController.class -> fetchDepartment.method");
       return departmentService.fetchDepartment();
   }

    @GetMapping("/departments/{Id}")
    public Department fetchDepartmentById(@PathVariable("Id") Long DepartmentId) throws DepartmentNotFoundExpection {
        return departmentService.fetchDepartmentById(DepartmentId);

    }

    @DeleteMapping("/departments/{Id}")
    public  String deleteDepartmentById(@PathVariable("Id") Long DepartmentId)
    {
        departmentService.deleteDepartmentById(DepartmentId);
        return "Department deleted sucessfully";

    }

    @PutMapping("/departments/{Id}")
    public Department updateDepartmentById(@PathVariable("Id") Long DepartmentId,@RequestBody Department department)
    {
        return departmentService.updateDepartmentById(DepartmentId,department );
    }

    @GetMapping("/departments/name/{Name}")
    public Department findDepartmentByName(@PathVariable("Name") String departmentName)
    {
        return departmentService.findDepartmentByName(departmentName);
    }



}
