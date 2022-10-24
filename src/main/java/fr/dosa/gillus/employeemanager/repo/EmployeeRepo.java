package fr.dosa.gillus.employeemanager.repo;

import fr.dosa.gillus.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
