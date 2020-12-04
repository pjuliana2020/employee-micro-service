package com.brighttalk.employee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brighttalk.employee.repository.EmployeeRepository;
import com.brighttalk.employee.repository.entity.EmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void givenEmployeeEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		EmployeeEntity employeeEntity = employeeRepository
				.save(new EmployeeEntity(100L, "Julian", "Pankiraj", "info@brighttalk.com", "7654568765"));
		Optional<EmployeeEntity> savedEntity = employeeRepository.findById(employeeEntity.getId());
		assertNotNull(savedEntity);
		assertEquals(employeeEntity.getId(), savedEntity.get().getId());
	}

	@Test
	public void givenEmployeeEntityRepository_whenUpdateAndRetreiveEntity_thenOK() {
		EmployeeEntity employeeEntity = employeeRepository
				.save(new EmployeeEntity(100L, "Julian", "Pankiraj", "admin@brighttalk.com", "7654568765"));
		Optional<EmployeeEntity> updatedEntity = employeeRepository.findById(employeeEntity.getId());
		assertNotNull(updatedEntity);
		assertEquals(employeeEntity.getEmail(), updatedEntity.get().getEmail());
	}

	@Test
	public void findAllEmployeeEntityListRepository_thenOK() {
		List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
		assertNotNull(employeeEntityList);
		assertEquals(employeeEntityList.size(), 1);
	}

}
