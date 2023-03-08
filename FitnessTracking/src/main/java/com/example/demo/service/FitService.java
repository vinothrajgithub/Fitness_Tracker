package com.example.demo.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Fit;
import com.example.demo.repository.FitRepo;
@Service

public class FitService {
	@Autowired
	FitRepo repository; 
	
	public String addFit(Fit fit) 
	{
		repository.save(fit);
		return "Added";
	}
	public List<Fit> getFit()
	{
		return repository.findAll();
	}
	
	public String updateBook(Fit fit)
	{
		repository.save(fit);
		return " Fit is Updated ";
	}
	public String deleteFitById(int id) {
	    repository.deleteById(id);
	    return "Fit Removed";
	}
	public List<Fit> getFitSorted(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	public List<Fit> getFitWithPagination(@PathVariable int offset, @PathVariable int pageSize)
	{
		Page<Fit> page=repository.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
	public List<Fit> getFitWithSortingAndPagination(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize,Sort.by(field));
		Page<Fit> page=repository.findAll(paging);
		return page.getContent();
	}
	

}
