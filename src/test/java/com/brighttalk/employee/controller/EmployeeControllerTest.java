package com.brighttalk.employee.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.brighttalk.employee.exception.EmployeeRecordNotFoundException;
import com.brighttalk.employee.repository.entity.EmployeeEntity;
import com.brighttalk.employee.service.EmployeeService;

@RunWith(SpringRunner.class)

public class EmployeeControllerTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	public void givenEmployeeEntityService_whenSaveAndRetreiveEntity_thenOK() throws EmployeeRecordNotFoundException {
		EmployeeEntity employeeEntity = employeeService.saveOrUpdateEmployee(
				new EmployeeEntity(100L, "Julian", "Pankiraj", "info@brighttalk.com", "7654568765"));
		EmployeeEntity savedEntity = employeeService.getEmployeeById(employeeEntity.getId());
		assertNotNull(savedEntity);
		assertEquals(employeeEntity.getId(), savedEntity.getId());
	}

	@Test
	public void findAllEmployeeEntityListService_thenOK() {
		List<EmployeeEntity> employeeEntityList = employeeService.getAllEmployees();
		assertNotNull(employeeEntityList);
		assertEquals(employeeEntityList.size(), 1);
	}

}
