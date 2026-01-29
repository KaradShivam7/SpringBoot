package flipcart.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flipcart.order.dto.Employeedto;
import flipcart.order.entity.Employee;


@RestController
@RequestMapping("/employee")
public class userControler {
	
List<Employee> uss=new ArrayList<Employee>();
	
	
	
	@PostMapping("/add-employee")
    public Employee addemployee(@RequestBody Employee employee)
    {
		
	     if(employee!=null)
	     {
	    	  uss.add(employee);
	    	  System.out.println("Size of DB:"+uss.size());
	    	  
	    	  System.out.println(employee.getName()+" of Company :"+employee.getCompany().getCompany_name()+ " "+"added sucessfully");
	     }
	     
	     return employee;
    }
	
	@GetMapping("/get")
	public List<Employeedto> get(){
		return uss.stream().map((emp)->{
		Employeedto ed =new Employeedto();
		ed.setCompany_name(emp.getCompany().getCompany_name());
		ed.setEid(emp.getEid());
		ed.setGst_number(emp.getCompany().getGst_number());
		ed.setName(emp.getName());
		return ed;})
		.collect(Collectors.toList());
	}

}
