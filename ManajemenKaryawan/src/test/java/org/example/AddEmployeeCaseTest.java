package org.example;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class AddEmployeeCaseTest {

  @Autowired
  private EmployeeService employeeService;

  @Test
  void savedUserHasRegistrationDate() {
    Employee ilyas = new Employee();
    ilyas.setEmpId("1111");
    ilyas.setName("Ilyas");
    ilyas.setAddress("condet");

    //di dalam method tambah ada set created date
    Employee employeeSaved = employeeService.tambah(ilyas);

    assertThat(employeeSaved.getCreatedDate()).isNotNull();
  }

}