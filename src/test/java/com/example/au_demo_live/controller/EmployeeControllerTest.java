package com.example.au_demo_live.controller;

import com.example.au_demo_live.exception.EmployeeNotFound;
import com.example.au_demo_live.models.Employee;
import com.example.au_demo_live.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    List<Employee> createMockEmployees(){
        final var employees = new ArrayList<Employee>();
        employees.add(new Employee("1","Sumit","1234"));
        employees.add(new Employee("2","Vasant","1234"));
        employees.add(new Employee("3","Patil","1234"));
        return employees;
    }

    @Test
    @DisplayName("/employees should return all employees")
    void testGetAllEmployees() throws Exception{

        when(employeeService.getAllEmployees()).thenReturn(createMockEmployees());

        final var expected = new ObjectMapper().writeValueAsString(createMockEmployees());

        mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expected));

    }

    @Test
    void testGetEmployee() throws Exception{
        when(employeeService.getEmployee(anyString())).thenThrow(new EmployeeNotFound());

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/123"))
                .andExpect(status().isNotFound());
    }
}