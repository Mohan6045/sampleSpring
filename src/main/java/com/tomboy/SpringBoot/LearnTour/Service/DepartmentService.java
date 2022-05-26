package com.tomboy.SpringBoot.LearnTour.Service;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import com.tomboy.SpringBoot.LearnTour.Error.DepartmentNotFoundExpection;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExpection;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

   public Department findDepartmentByName(String departmentName);
}
