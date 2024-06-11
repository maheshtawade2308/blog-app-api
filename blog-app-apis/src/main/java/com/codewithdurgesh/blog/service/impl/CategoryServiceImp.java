package com.codewithdurgesh.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.model.Category;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.repository.CategoryRepository;
import com.codewithdurgesh.blog.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category createdCat =this.categoryRepository.save(this.modelMapper.map(categoryDto, Category.class));
		
		return this.modelMapper.map(createdCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		System.out.println(cat);
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCategory = this.categoryRepository.save(cat);
		
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}
	
	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		this.categoryRepository.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat = this.categoryRepository.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryID", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> catList = this.categoryRepository.findAll();
		List<CategoryDto> catDtos = catList.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class))
				.collect(Collectors.toList());
		return catDtos;
	}

}
