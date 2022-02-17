package dev.revature.Service.Abstract;

import dev.revature.Entities.Employee;

public interface EmployeeService {
    Employee createEmployeeService(Employee employee);
    Employee getLoginService(String username, String password);
    Boolean deleteEmployeeService(int employeeId);
}
