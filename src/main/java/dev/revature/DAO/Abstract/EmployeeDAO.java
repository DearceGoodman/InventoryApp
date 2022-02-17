package dev.revature.DAO.Abstract;

import dev.revature.Entities.Employee;

public interface EmployeeDAO {

    Employee createEmployee(Employee employee);
    Employee getEmployeeLoginByCredential(String username, String password);
    Boolean deleteEmployee(int employeeId);


}
