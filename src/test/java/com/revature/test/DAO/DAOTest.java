package com.revature.test.DAO;

import CustomExceptions.DuplicateEmployeeIdException;
import CustomExceptions.InvalidCredentialException;
import dev.revature.DAO.Abstract.EmployeeDAO;
import dev.revature.DAO.Abstract.ItemsDAO;
import dev.revature.DAO.Implementation.EmployeeDAOImp;
import dev.revature.DAO.Implementation.ItemsDAOImp;
import dev.revature.Entities.Employee;
import dev.revature.Entities.Items;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DAOTest {
    EmployeeDAO employeeDAO = new EmployeeDAOImp();
    ItemsDAO itemsDAO = new ItemsDAOImp();

    @Test
    void createEmployee(){
        try {
            Employee employee = new Employee("Dearce", "Goodman", "baldy", "golden"
                    , "216 Carlon Way, Decatur GA 30030", "Food Runner", 0);
            Employee newEmployee = employeeDAO.createEmployee(employee);
            Assert.assertTrue(newEmployee.getEmployeeId() != 0);

        }catch(DuplicateEmployeeIdException e){
            Assert.assertEquals("This employee ID is already taken", e.getMessage());
        }
    }

    @Test
    void deleteEmployeeSuccess(){
        boolean deleteEmployee  = employeeDAO.deleteEmployee(1);
        Assert.assertTrue(deleteEmployee);
    }

    @Test
    void employeeLoginSuccess(){
        Employee employeeLogin = employeeDAO.getEmployeeLoginByCredential("baldy", "golden");
        Assert.assertEquals(employeeLogin.getUsername(), "baldy");
        Assert.assertEquals(employeeLogin.getPassword(),"golden");
    }

    @Test
    void invalidPassword(){
        try{
            Employee badLogin = employeeDAO.getEmployeeLoginByCredential("baldy", "golden");
            Assert.assertNotEquals(badLogin.getPassword(), "123");

        }catch(InvalidCredentialException e){
            Assert.assertEquals("Your username/password is wrong", e.getMessage());
        }
    }



    @Test
    void createItemSuccess(){
        Items item = new Items(1,"Pillsbury All Purpose", 23333333, 16,
                "F3","Flour", 64 );
        Items newItem = itemsDAO.createItems(item);
        Assert.assertTrue(newItem.getItemNumber() != 0);
    }

    @Test
    void deleteItemSuccess(){
        Boolean deletedItem = itemsDAO.deleteItems(5);
        Assert.assertTrue(deletedItem);
    }

    @Test
    void decrementItemCount(){

    }

}
