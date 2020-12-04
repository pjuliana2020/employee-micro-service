package com.brighttalk.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brighttalk.employee.exception.EmployeeRecordNotFoundException;
import com.brighttalk.employee.repository.entity.EmployeeEntity;
import com.brighttalk.employee.repository.EmployeeRepository;
 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repo;
     
    public List<EmployeeEntity> getAllEmployees()
    {
        List<EmployeeEntity> employeeList = repo.findAll();
         
        if(!employeeList.isEmpty() && employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<EmployeeEntity>();
        }
    }
     
    public EmployeeEntity getEmployeeById(final Long id) throws EmployeeRecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repo.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new EmployeeRecordNotFoundException("There is no employee record exist for given id");
        }
    }
     
    public EmployeeEntity saveOrUpdateEmployee(EmployeeEntity entity) throws EmployeeRecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repo.findById(entity.getId());
         
        if(employee.isPresent())
        {
            EmployeeEntity employeeEntity = employee.get();
            employeeEntity.setFirstName(entity.getFirstName());
            employeeEntity.setLastName(entity.getLastName());
            employeeEntity.setEmail(entity.getEmail());
            employeeEntity.setPhone(entity.getPhone());
            employeeEntity = repo.save(employeeEntity);
            return employeeEntity;
        } else {
            entity = repo.save(entity);
            return entity;
        }
    }
     
    public void deleteEmployeeById(final Long id) throws EmployeeRecordNotFoundException
    {
        Optional<EmployeeEntity> employee = repo.findById(id);
         
        if(employee.isPresent())
        {
        	repo.deleteById(id);
        } else {
            throw new EmployeeRecordNotFoundException("There is no employee record exist for given id");
        }
    }
}
