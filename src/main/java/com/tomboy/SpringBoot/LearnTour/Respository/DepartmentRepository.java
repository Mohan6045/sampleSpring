package com.tomboy.SpringBoot.LearnTour.Respository;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

   public Department findByDepartmentName(String departmentName);
   public Department findByDepartmentNameIgnoreCase(String departmentName);
}
