// Repository Access Database Layer  

//First Create Repo Folder Inside The Create repository File and Create Interface class 
// Go with implement jparepository < Employee  -> Kai Entity mate CRUD joiye
//                                  Long      -> Primary Key no datatype >

package com.employecrud.Employe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employecrud.Employe.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}   
