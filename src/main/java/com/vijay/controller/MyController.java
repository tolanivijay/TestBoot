package com.vijay.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.model.EmpResponse;
import com.vijay.model.Employee;
import com.vijay.repo.EmpRepository;

@RestController
@RequestMapping(value="employee")
public class MyController {
	
	private List<String> strList = new ArrayList<String>();
	
	@Autowired
	private EmpRepository repo;
	
	@Autowired
	private MongoTemplate template;
	
	@Value("${name1}")
    private String name;
	
	@Bean
	public String name2() {
		return "Deep1";
	}
	
	public MyController(){
		strList.add("1");
		strList.add("2");
		strList.add("3");
	}
	
	//@RequestMapping(path="entity/all", method=RequestMethod.GET)
	@GetMapping(path ="list")
    public List<Employee> findAll() {
        //return getEmployees();
		List<Employee> empList = new ArrayList<>();
		
		//repo.findAll().forEach(empList::add);
		empList =template.findAll(Employee.class);
		return empList;
    }
	
	@PostMapping(path="add")
	public EmpResponse upsurdAnEmployee(@RequestBody Employee emp) {
		EmpResponse resp = new EmpResponse();
		//repo.save(emp);
		resp.setStatus("Sucess");
		return resp;
	}
	
	@RequestMapping("/greet")
	public String sayGreeting() {
		return "Welcome " + name;
	}
	
	
	private List<Employee> getEmployees(){
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId("1");emp.setName("deep");
		empList.add(emp);
		emp.setId("2");emp.setName("pia");
		empList.add(emp);
		
		return empList;
	}

}
