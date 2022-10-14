package com.mnemonic.api;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mnemonic.entity.Category;
import com.mnemonic.service.CategoryService;



@RestController
@RequestMapping("/api/v1/mnemonic/category")
@ComponentScan("com.mnemonic.service")


public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public List getAllCategory() {
		
		return categoryService.getAllCategories();
		
	}
	
	@GetMapping(value = "/{id}")
	@ResponseBody
	public Optional<Category> getById(@PathVariable("id") Long id) {
		
		return categoryService.findById(id);
	}
	
	@GetMapping
	public Category getByName(@RequestParam(value="name") String name) {
		
		return categoryService.findByName(name);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteCategory(@PathVariable("id") String id) {
		
		categoryService.deleteById(Long.parseLong(id));
	
		
	}
	
	
}
