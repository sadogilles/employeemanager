package fr.dosa.gillus.employeemanager.repo;

import fr.dosa.gillus.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Employee correspond to the class we want to create a repository for and Long is the type of the id attribute.
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id); //spring is going to create a query based on the method name to delete the employee row

    Employee findEmployeeById(Long id);

}
