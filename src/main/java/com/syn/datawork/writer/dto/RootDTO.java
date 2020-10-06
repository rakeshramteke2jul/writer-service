package com.syn.datawork.writer.dto;

import java.util.List;

public class RootDTO {
	
	    public String status;
	    public List<EmployeeDTO> data;
	    public String message;
	    
	
		public List<EmployeeDTO> getData() {
			return data;
		}
		public void setData(List<EmployeeDTO> data) {
			this.data = data;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	    
	    

}
