package dev.revature.APP;

import dev.revature.Controller.EmployeeController;
import dev.revature.DAO.Abstract.EmployeeDAO;
import dev.revature.DAO.Implementation.EmployeeDAOImp;
import dev.revature.Service.Abstract.EmployeeService;
import dev.revature.Service.Implementation.EmployeeServiceImp;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });


        EmployeeDAO employeeDAO = new EmployeeDAOImp();
        EmployeeService employeeService = new EmployeeServiceImp(employeeDAO);
        EmployeeController employeeController = new EmployeeController(employeeService);

        //methods
        app.post("/employee", employeeController.createEmployee);
        app.post("/login", employeeController.getEmployeeLoginByCredential);
        app.delete("/employee/delete/{employeeId}", employeeController.deleteEmployee);

    app.start();
    }
}
