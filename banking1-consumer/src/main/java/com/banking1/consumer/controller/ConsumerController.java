package com.banking1.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.banking1.consumer.dto.Employee;

@RestController
@RequestMapping("/api/v1/consumers")
public class ConsumerController {
	
	@Autowired
	private DiscoveryClient ds;
	
	@GetMapping
	public List<Employee> consumeAllEmployee(){
		
		 List<ServiceInstance> ss=ds.getInstances("GATEWAYBATCH5");
		 ServiceInstance s1=ss.get(0);
		 
		 String url=s1.getUri().toString();
		
		RestTemplate rtemp=new RestTemplate();
		
	List<Employee> ee= rtemp.getForObject(url+"/api/v1/employees", List.class);
		
		return ee;
	}
	
	@PostMapping
	public String consumecreateEmployee(@RequestBody Employee emp){
		 List<ServiceInstance> ss=ds.getInstances("GATEWAYBATCH5");
		 ServiceInstance s1=ss.get(0);
		 
		 String url=s1.getUri().toString();
		
		RestTemplate rtemp=new RestTemplate();
		
	String ee= rtemp.postForObject(url+"/api/v1/employees",emp, String.class);
		
		return ee;
	}
	
	@PutMapping ("/{uid}")
	public String consumeeditEmployee(@PathVariable("uid") String email,@RequestBody Employee emp){
		
		 List<ServiceInstance> ss=ds.getInstances("GATEWAYBATCH5");
		 ServiceInstance s1=ss.get(0);
		 
		 String url=s1.getUri().toString();
		
		RestTemplate rtemp=new RestTemplate();
		
	    rtemp.put(url+"/api/v1/employees/"+email,emp);
		
		return "record edited";
	}
	
	@DeleteMapping ("/{uid}")
	public String consumedeleteEmployee(@PathVariable("uid") String email){
		
		 List<ServiceInstance> ss=ds.getInstances("GATEWAYBATCH5");
		 ServiceInstance s1=ss.get(0);
		 
		 String url=s1.getUri().toString();
		
		RestTemplate rtemp=new RestTemplate();
		
	    rtemp.delete(url+"/api/v1/employees/"+email);
		
		return "record deleted";
	}

}
