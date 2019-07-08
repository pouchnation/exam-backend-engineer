package com.pouchnation.exam;

import javax.servlet.http.HttpServletRequest;

import com.pouchnation.exam.models.entities.Animal;
import com.pouchnation.exam.models.response.APIResponse;
import com.pouchnation.exam.repositories.AnimalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExamController {

	@Autowired
	private AnimalRepository repository;

    @RequestMapping(value =  "/", method = RequestMethod.GET)
	public @ResponseBody APIResponse getHome(HttpServletRequest request) {
		APIResponse response = new APIResponse();
		response.setData("ok");
		return response;
	}

	@RequestMapping(value =  "/animals", method = RequestMethod.GET)
	public @ResponseBody APIResponse generateTestData(HttpServletRequest request) {
		long count = repository.count();

		if ( count == 0 ){
			Animal dog = new Animal();
			dog.setName("dog");
			repository.save(dog);

			Animal cat = new Animal();
			cat.setName("cat");
			repository.save(cat);
		} 

		APIResponse response = new APIResponse();
		response.setData(repository.findAll());
		return response;
	}

}
