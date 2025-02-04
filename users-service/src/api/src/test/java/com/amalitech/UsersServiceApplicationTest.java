package com.amalitech;
import com.amalitech.entities.Employee;
import com.amalitech.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UsersServiceApplicationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UsersServiceApplication usersServiceApplication;

    @BeforeEach
    public void setUp() {
        employeeRepository.deleteAll();
    }

    @Test
    public void testSeedEmployees() {
        usersServiceApplication.seedEmployees();

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        assertEquals(2, employees.size());
        assertEquals("Fredrick Amoako", employees.get(0).getName());
        assertEquals("Winfred Agbotey", employees.get(1).getName());
    }

    @Test
    public void testGetEmployees() {
        Employee emp1 = Employee.builder().id(2).name("Fredrick Amoako").department("Service Center").build();
        Employee emp2 = Employee.builder().id(3).name("Winfred Agbotey").department("Service Center").build();
        employeeRepository.saveAll(List.of(emp1, emp2));

        Iterable<Employee> result = usersServiceApplication.getEmployees();

        List<Employee> employees = (List<Employee>) result;
        assertEquals(2, employees.size());
        assertEquals("Fredrick Amoako", employees.get(0).getName());
        assertEquals("Winfred Agbotey", employees.get(1).getName());
    }

    @Test
    public void testRun() throws Exception {
        usersServiceApplication.run();

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        assertEquals(2, employees.size());
    }
}



