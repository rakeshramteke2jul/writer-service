package com.syn.datawork.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.syn.datawork.writer.model.Employee;
import com.syn.datawork.writer.repository.EmployeeRepository;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeWriter.class);
	@Autowired
	EmployeeRepository employeeRepo;

	public void write(List<? extends Employee> items) throws Exception {
		LOGGER.info("Received the information of {} employee", items.size());

		employeeRepo.saveAll(items);

		items.forEach(i -> LOGGER.debug("Received the information of a employee: {}", i));
	}

}
