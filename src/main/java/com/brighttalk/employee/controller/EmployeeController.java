package com.brighttalk.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotEmpty;
import com.brighttalk.employee.exception.EmployeeRecordNotFoundException;
import com.brighttalk.employee.repository.entity.EmployeeEntity;
import com.brighttalk.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") @NotEmpty final Long id)
                                                    throws EmployeeRecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
                                                    throws EmployeeRecordNotFoundException {
        EmployeeEntity updated = service.saveOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") @NotEmpty final Long id)
                                                    throws EmployeeRecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
 
}