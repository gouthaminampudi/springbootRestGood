/**
 * 
 */
package com.goutham.springboot.resapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.goutham.springboot.database.DTOEntity;
import com.goutham.springboot.database.SpringRepositoryInterface;

/**
 *
 */
//Controller will display output with view where as RestController will display output without view
@EntityScan("com.goutham.springboot.database") //Need to use this if Entity is in a different package
@EnableJpaRepositories("com.goutham.springboot.database") //Need to use this if JPA Repository is in a different package
@RestController
@CrossOrigin
public class HelloController {
	@Autowired
	SpringRepositoryInterface repository;

	@Value("${welcome.message:Hello World}")
	private String message = "Hello World";



	@RequestMapping("/")
	public String foo(Map<String, Object> model) {

		model.put("message", this.message);
		return "welcome";


	}

	@CrossOrigin
	@RequestMapping(value = "/getAll", method = RequestMethod.GET )
	public List<DTOEntity> returnAll(Map<String, Object> model) {

		//model.put("message", demo());
		System.out.println("This is my output");
		return demo();


	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		repository.delete(Long.valueOf(id));
	}
	
	 @RequestMapping(method=RequestMethod.POST, value="/addUser")
	   @ResponseBody
	   public DTOEntity addUser(@RequestBody DTOEntity e) {
		 DTOEntity created = repository.save(e);
	     return created;
	   }
	
	 @RequestMapping(method=RequestMethod.PUT, value="/updateUser/{id}")
	   @ResponseBody
	   public DTOEntity updateUser(@PathVariable("id") int id, @RequestBody DTOEntity e) {
		 
		 DTOEntity toUpdate = repository.findOne(Long.valueOf(id));
		 toUpdate.setFirstName(e.getFirstName());
		 toUpdate.setLastName(e.getLastName());
		 DTOEntity updated = repository.save(toUpdate);
	     return updated;
	   }
	 @CrossOrigin
	 @RequestMapping(method=RequestMethod.GET, value="/getUserByString", params={"name"})
	   public  List<DTOEntity> getUserByName(@RequestParam("name") String name) {
		 List<DTOEntity> customers = new ArrayList<DTOEntity>();
			for (DTOEntity customer : repository.findByFirstName(name)) {
				customers.add(customer);
			}

			return customers;

	   }
	 
	 
	 
	@Bean
	public List<DTOEntity> demo() {



		List<DTOEntity> customers = new ArrayList<DTOEntity>();
			for (DTOEntity customer : repository.findAll()) {
				customers.add(customer);
			}

			return customers;

	}

}
