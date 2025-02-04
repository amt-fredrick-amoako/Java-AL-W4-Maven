package com.amalitech;

import com.amalitech.entities.Employee;
import com.amalitech.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class UsersServiceApplication implements CommandLineRunner
{
    private final EmployeeRepository employeeRepository;

    public UsersServiceApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main( String[] args )
    {
        SpringApplication.run(UsersServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        seedEmployees();
        System.out.println(getEmployees());
    }

    public void seedEmployees() {
        if (employeeRepository.count() == 0) {
            List<Employee> employees = List.of(
                    Employee.builder().id(2).name("Fredrick Amoako").department("Service Center").build(),
                    Employee.builder().id(3).name("Winfred Agbotey").department("Service Center").build()
            );

            employeeRepository.saveAll(employees);
        }
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

}
