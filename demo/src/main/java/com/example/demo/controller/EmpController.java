package com.example.demo.controller;

import com.example.demo.dao.EmpDao;
import com.example.demo.entitiy.Employee;
import com.example.demo.myexception.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmpController {


    @Autowired
  EmpDao empDao;

//    Create an Employee Bean(id, name, age) and service to  perform different operations related to employee.

    //-------------------------------------------------------------------------------------------
    //    Implement POST http request for Employee to create a new employee.

    @PostMapping("/employees")
    public ResponseEntity<Object> saveEmployeeRecord(@RequestBody Employee employee)
    {
       Employee emp1= empDao.createEmpRecord(employee);

        //After Created
        //Return Status of Create
       URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp1.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    //-------------------------------------------------------------------------------------------
    //    Implement GET http request for Employee to get list of employees.

    @GetMapping("/employees")
    public List<Employee> retrieveEmpRecord()
    {

        return empDao.getEmployeeslist();
    }

    //-------------------------------------------------------------------------------------------

    //    Implement GET http request using path variable top get one employee
    @GetMapping("/employees/{id}")
    public Employee  retrieveEmployee(@PathVariable int id)
    {
        Employee emp= empDao.getEmployeeById(id);
        if(emp==null)
        {
            throw new EmployeeNotFoundException("Sorry !! The record related to this ID : "+id +" is not Exist.." );
        }

         return emp;

        //HATEOAS




        //End




    }

    //---------------------------------------------------------------------------------------------
    @DeleteMapping("/employees/{id}")
    public void  removeEmployee(@PathVariable int id)
    {
        Employee emp2= empDao.deleteEmployeeById(id);
        if(emp2==null)
        {
            throw new EmployeeNotFoundException("Sorry !! The record related to this ID : "+id +" is not Exist.." );
        }
    }


}
