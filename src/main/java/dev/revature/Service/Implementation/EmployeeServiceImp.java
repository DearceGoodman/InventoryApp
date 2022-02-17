package dev.revature.Service.Implementation;

import CustomExceptions.InvalidCredentialException;
import dev.revature.DAO.Abstract.EmployeeDAO;
import dev.revature.Entities.Employee;
import dev.revature.Service.Abstract.EmployeeService;

public class EmployeeServiceImp implements EmployeeService {

    EmployeeDAO employeeDAO;
        public EmployeeServiceImp(EmployeeDAO employeeDAO) {
            this.employeeDAO = employeeDAO;
        }

    @Override
    public Employee createEmployeeService(Employee employee) {
        return this.employeeDAO.createEmployee(employee);
    }

    @Override
    public Employee getLoginService(String username, String password) {
            try {
                return this.employeeDAO.getEmployeeLoginByCredential(username, password);

            } catch (InvalidCredentialException e){
                return null;
            }

    }

    @Override
    public Boolean deleteEmployeeService(int employeeId) {
            try {
                return this.employeeDAO.deleteEmployee(employeeId);

            }catch (Exception e){
                return false;
            }
    }
}
