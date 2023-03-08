package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fit;
import com.example.demo.service.FitService;

@RestController
@CrossOrigin("*")
public class FitnessTracker {
	@Autowired
	FitService service;
	
	@PostMapping("/postfit")
	public String add(@RequestBody Fit fit)
	{
		return service.addFit(fit);
	}
	
	@GetMapping("/fit")
	public List<Fit> get()
	{
		return service.getFit();
	}

	@PutMapping("/fit")
	public String update(@RequestBody Fit fit)
	{
		return service.updateBook(fit);
	}
	
	@DeleteMapping("/fit")
		public String delete(@RequestParam int id)
		{
		return service.deleteFitById(id);
		}
	@GetMapping("/fit/{field}")
	public List<Fit> fitWithSort(@PathVariable String field)
	{
		return service.getFitSorted(field);
	}
	@GetMapping("/fit/{offset}/{pageSize}")
	public List<Fit>fitWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return service.getFitWithPagination(offset, pageSize );
	}
	@GetMapping("/f=it/{offset}/{pageSize}/{field}")
	public List<Fit> fitWithSortingAndPagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return service.getFitWithSortingAndPagination(offset, pageSize,field );
	}
}

