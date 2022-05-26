package com.tomboy.SpringBoot.LearnTour.Service;

import com.tomboy.SpringBoot.LearnTour.Entity.Department;
import com.tomboy.SpringBoot.LearnTour.Error.DepartmentNotFoundExpection;
import com.tomboy.SpringBoot.LearnTour.Respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public  class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department)
    {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment()
    {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExpection {

        Optional<Department> department= departmentRepository.findById(departmentId);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundExpection("Department is not available");

        }

        return  department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {

        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName())&&!" ".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&!" ".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&!" ".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        
        return departmentRepository.save(depDB);
    }

    @Override
    public Department findDepartmentByName(String departmentName) {
       // return departmentRepository.findByDepartmentName(departmentName);
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);  // Ignore case

    }


}
