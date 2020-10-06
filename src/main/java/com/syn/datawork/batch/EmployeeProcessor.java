package com.syn.datawork.batch;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.syn.datawork.writer.dto.EmployeeDTO;
import com.syn.datawork.writer.model.Employee;



public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee>{
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProcessor.class);

	 @Autowired
	 private ModelMapper modelMapper;
	 
	    @Override
	    public Employee process(EmployeeDTO item) throws Exception {
	        LOGGER.info("Processing employee information: {}", item);
	        
	        Employee emp = convertToEntity(item);
	        return emp;
	    }
	    
	    private Employee convertToEntity(EmployeeDTO employeeDto) {
	    	   
	        Employee employee =	modelMapper.map(employeeDto, Employee.class);
	        
	        return employee;
	       	
	    }

}
