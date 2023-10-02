package org.example;

import org.example.model.Data;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.junit.jupiter.api.*;


public class EmployeeTestEach {
    Employee employee;
    EmployeeService employeeService;

    @BeforeEach
    void createEmployeeBefore(){
        employee =  new Employee();
        employee.setEmpId("111111");
        employee.setDepartement(Data.departementMap.get(1));
        employee.setName("Ilyas");
        employee.setAddress("Condet");

        employeeService = new EmployeeService();
        employeeService.createEmployee(employee);
    }

    @Test
    @DisplayName("Positive Test -> Employee By ID")
    void getByEmpIdSuccess(){
        Employee empGet = employeeService.getEmployeeByEmpId("111111");
        Assertions.assertTrue(empGet instanceof Employee);
    }

    @Test
    @DisplayName("Positive Test -> Employee Name ")
    void getByEmpIdCheckName(){
        Employee empGet = employeeService.getEmployeeByEmpId("111111");
        Assertions.assertTrue(empGet.getName().equals("Ilyas"));
    }

    @Test
    @DisplayName("Positive Test -> Employee By ID AssertSame")
    void getByEmpIdSame(){
        Employee empGet = employeeService.getEmployeeByEmpId("111111");
        Assertions.assertSame(employee, empGet);
    }
}
