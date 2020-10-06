package com.syn.datawork.batch;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.syn.datawork.writer.dto.EmployeeDTO;
import com.syn.datawork.writer.dto.RootDTO;



public class EmployeeReader implements ItemReader<EmployeeDTO>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeReader.class);

    private final String apiUrl;
    
    private final RestTemplate restTemplate;

    private int nextEmployeeIndex;
    private List<EmployeeDTO> employeeData;


    public EmployeeReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextEmployeeIndex = 0;
    }

    @Override
    public EmployeeDTO read() throws Exception {
        LOGGER.info("Reading the information of the next student");

        if (employeeDataIsNotInitialized()) {
        	employeeData = fetchEmployeeDataFromAPI();
        }

        EmployeeDTO nextEmployee = null;

        if (nextEmployeeIndex < employeeData.size()) {
        	nextEmployee = employeeData.get(nextEmployeeIndex);
            nextEmployeeIndex++;
        }

        LOGGER.info("Found student: {}", nextEmployee);

        return nextEmployee;
    }
    
    private boolean employeeDataIsNotInitialized() {
        return this.employeeData == null;
    }

    private List<EmployeeDTO> fetchEmployeeDataFromAPI() {
        LOGGER.debug("Fetching student data from an external API by using the url: {}", apiUrl);

        ResponseEntity<RootDTO> response = restTemplate.getForEntity(apiUrl,RootDTO.class);
        List<EmployeeDTO>  employeeList = response.getBody().getData();
        LOGGER.debug("Found {} students", employeeList.size());

        return employeeList;
    }
    
}
