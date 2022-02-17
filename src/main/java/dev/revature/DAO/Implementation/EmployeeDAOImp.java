package dev.revature.DAO.Implementation;

import dev.revature.DAO.Abstract.EmployeeDAO;
import dev.revature.Entities.Employee;
import dev.revature.Utility.DatabaseConnection;

import java.sql.*;

public class EmployeeDAOImp implements EmployeeDAO {

    @Override
    public Employee createEmployee(Employee employee) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "insert into customer_db values (?,?,?,?,?,?, default)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getJobTitle());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            return employee;


        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee getEmployeeLoginByCredential(String username, String password) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from customer_db where username = ? and password = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Employee customerLogin= new Employee();
            customerLogin.setEmployeeId(resultSet.getInt("employee_id"));
            customerLogin.setFirstName(resultSet.getString("first_name"));
            customerLogin.setLastName(resultSet.getString("last_name"));
            customerLogin.setUsername(resultSet.getString("username"));
            customerLogin.setPassword(resultSet.getString("password"));
            customerLogin.setAddress(resultSet.getString("address"));
            customerLogin.setJobTitle(resultSet.getString("job_title"));
            return customerLogin;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteEmployee(int employeeId) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "delete from customer_db where employee_id = ?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
        return true;
    }


}
