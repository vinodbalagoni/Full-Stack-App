package com.vinod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class EmpController {
	
	@Autowired
	private EmpRepository empRepository;
	
	
	@PostMapping("/employees")
	// create Employee rest api
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return empRepository.save(employee);
		
	}
//	//get Employee by  id
//		@GetMapping("/employees/{Eid}")
//		public ResponseEntity<Employee> getEmployeeById(@PathVariable("Eid") Long Eid)
//		{
//			Employee employee=empRepository.findById(Eid)
//					.orElseThrow(()->new ResourceNotFoundException("employee not exits with id"+Eid));
//			return ResponseEntity.ok(employee);
//			
//		}
		
		@GetMapping("/employees/{emailId}")
		public ResponseEntity<Employee> getEmpByemailId(@PathVariable("emailId") String emailId)
		{
			Employee employee=empRepository.findByemailId(emailId);
					 
			return ResponseEntity.ok(employee);
			
		}
		

}
