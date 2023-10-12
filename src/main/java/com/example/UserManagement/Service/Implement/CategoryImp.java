package com.example.UserManagement.Service.Implement;

import com.example.UserManagement.Entities.Category;
import com.example.UserManagement.Entities.User;
import com.example.UserManagement.Exception.ResourceNotFoundException;
import com.example.UserManagement.Repository.CategoryRepository;
import com.example.UserManagement.Service.CategoryService;
import com.example.UserManagement.dto.Categorydto;
import com.example.UserManagement.dto.Userdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Categorydto create(Categorydto cat) {
        Category category=this.dtoToCategory(cat);
        Category savecat=categoryRepository.save(category);
        return this.Categorytodto(savecat);

    }

    @Override
    public Categorydto getbyId(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("Category","Id",id)));
        return this.Categorytodto(category);
    }

    @Override
    public Categorydto updatebyId(Categorydto cat, Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("Category","Id",id)));
        category.setCategorytitle(cat.getCategorytitle());
        category.setCategorydescription(cat.getCategorydescription());
        Category updatecat=categoryRepository.save(category);
        return this.Categorytodto(updatecat);
    }

    @Override
    public List<Categorydto> getall() {
        List <Category> category=categoryRepository.findAll();
        List<Categorydto> catdto=category.stream().map(cat1 -> this.Categorytodto(cat1)).collect(Collectors.toList());
        return catdto;
    }

    @Override
    public void deletebyId(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("Category","Id",id)));
        categoryRepository.delete(category);
    }
    public Category dtoToCategory(Categorydto categorydto) {
        Category category = modelMapper.map(categorydto,Category.class);
//        user.setId(userdto.getId());
//        user.setName(userdto.getName());
//        user.setEmail(userdto.getEmail());
//        user.setPassword(userdto.getPassword());
//        user.setAbout(userdto.getAbout());
        return category;
    }
    public Categorydto Categorytodto(Category category){
        Categorydto catdto=modelMapper.map(category,Categorydto.class);
//        userdto.setId(user.getId());
//        userdto.setName(user.getName());
//        userdto.setEmail(user.getEmail());
//        userdto.setPassword(user.getPassword());
//        userdto.setAbout(user.getAbout());
        return catdto;
    }
}
