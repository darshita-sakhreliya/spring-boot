package com.employecrud.Employe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employecrud.Employe.entity.Employee;
import com.employecrud.Employe.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }


    public Employee savEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
        
    }
    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
        //Employee Exist or not so that i can plase orelse(null)
    }

    public Employee updateEmployee(long id , Employee updatedEmployee){
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null){
            return null;
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        return employeeRepository.save(existingEmployee);
    }   
    public String deleteEmployee(long id){
            if(!employeeRepository.existsById(id)){
                return "Employee Not Found ";
            }
            employeeRepository.deleteById(id);
            return "Deleted Successfully Employee";
    }
}   
