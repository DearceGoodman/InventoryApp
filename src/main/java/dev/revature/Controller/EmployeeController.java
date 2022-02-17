package dev.revature.Controller;

import CustomExceptions.InvalidCredentialException;
import com.google.gson.Gson;
import dev.revature.Entities.Employee;
import dev.revature.Service.Abstract.EmployeeService;
import io.javalin.http.Handler;

import java.util.Map;


public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Handler createEmployee = ctx ->{
        Gson gson = new Gson();
        Employee newEmployee = gson.fromJson(ctx.body(), Employee.class);
        Employee createdEmployee = this.employeeService.createEmployeeService(newEmployee);
        String createdCustomerJson = gson.toJson(createdEmployee);
        ctx.result(createdCustomerJson);
        ctx.status(201);

    };

    public  Handler getEmployeeLoginByCredential = ctx ->{

        try{
            Gson gson = new Gson();
            Map<String, String> credentials = gson.fromJson(ctx.body(), Map.class);
            Employee validateLogin = this.employeeService.getLoginService(credentials.get("username"), credentials.get("password"));
            String validateLoginJson = gson.toJson(validateLogin);
            ctx.result(validateLoginJson);
            ctx.status(200);

        }catch(InvalidCredentialException e){
            ctx.result(e.getMessage());
            ctx.status(400);
        }
    };

    public Handler deleteEmployee = ctx ->{
        Gson gson = new Gson();
        int employeeId = Integer.parseInt(ctx.pathParam("employeeId"));

        boolean deleteEmp = this.employeeService.deleteEmployeeService(employeeId);
        String deleteEmpJson = gson.toJson(deleteEmp);
        ctx.result(deleteEmpJson);
        ctx.status(200);
    };

}
