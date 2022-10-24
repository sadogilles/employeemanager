package fr.dosa.gillus.employeemanager.service;

import fr.dosa.gillus.employeemanager.exception.EmployeeNotFoundException;
import fr.dosa.gillus.employeemanager.model.Employee;
import fr.dosa.gillus.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService { // annote the service with @Service and autowired the repository with dependency injection

    private final EmployeeRepo employeeRepo;
    //dependency injection of the EmployeeRepo
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return this.employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
         employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployee(Long id){
        return employeeRepo
                .findEmployeeById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("The employee with id : "+id+" was not found"));
    }
}
