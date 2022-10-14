package com.mnemonic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mnemonic.entity.Category;
import com.mnemonic.respositories.CategoryRepository;

@Component
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Optional<Category> findById(long id) {
		return categoryRepository.findById(id);

	}
	
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	
		}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public void deleteById(long id) {
		categoryRepository.deleteById(id);

	}
	

	

}
