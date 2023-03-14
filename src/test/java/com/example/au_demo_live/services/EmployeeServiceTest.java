package com.example.au_demo_live.services;

import com.example.au_demo_live.exception.EmployeeNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testGetEmployee_shouldReturnEmployeeIfFound(){
        assertThrows(EmployeeNotFound.class,()->employeeService.getEmployee("123"));
    }

    @Test
    void testGetEmployee_shouldThrowExceptionIfNotFound(){

    }

}