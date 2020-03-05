package com.example.demo.dao;

import com.example.demo.entitiy.Employee;
import org.springframework.stereotype.Component;
import sun.font.LayoutPathImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmpDao {

    //We use ArrayList (Collection) to store the object of Empolyees

    List<Employee> employeeslist = new ArrayList<>();

    //Create the employee
    public Employee createEmpRecord(Employee employee) {
        employeeslist.add(employee);
        return employee;
    }

    //Return all record
    public List<Employee> getEmployeeslist() {
//        if(employeeslist.size()>0)
//        {
      return employeeslist;
        }

    //Return record of particular id

    public Employee getEmployeeById(int id) {
        Iterator<Employee> listIterator = employeeslist.iterator();
        while (listIterator.hasNext()) {
            Employee employee = listIterator.next();
            if (employee.getId() == id) {
               return employee;
            }
         }

        return null;
    }

    //Delete record of particular id
    public Employee deleteEmployeeById(int id) {
        Iterator<Employee> listIterator = employeeslist.iterator();
        while (listIterator.hasNext()) {
            Employee employee = listIterator.next();
            if (employee.getId() == id) {
                listIterator.remove();
                return employee;
            }
        }

        return null;
    }


}
