package com.example.UserManagement.Controller;

import com.example.UserManagement.Service.CategoryService;
import com.example.UserManagement.Service.Implement.CategoryImp;
import com.example.UserManagement.dto.Categorydto;
import com.example.UserManagement.dto.Userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class CategoryController {
    @Autowired
    public CategoryService categoryService;
    @PostMapping("/category")
    public ResponseEntity<Categorydto> create(@Valid @RequestBody Categorydto categorydto){
        Categorydto createddto=categoryService.create(categorydto);
        return new ResponseEntity<>(createddto, HttpStatus.CREATED);
    }
    @GetMapping("/category")
    public ResponseEntity<List<Categorydto>> getall(){
        List<Categorydto> categorydto=categoryService.getall();
        return new ResponseEntity<>(categorydto,HttpStatus.FOUND);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<Categorydto> getbyid(@PathVariable("id")int id){
        Categorydto categorydto=categoryService.getbyId(id);
        return new ResponseEntity<>(categorydto,HttpStatus.FOUND);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Categorydto> delete(@PathVariable("id")int id){
        categoryService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Categorydto> update(@Valid @RequestBody Categorydto categorydto,@PathVariable("id")int id){
        Categorydto categorydto1=categoryService.updatebyId(categorydto,id);
        return new ResponseEntity<>(categorydto1,HttpStatus.CREATED);
    }

}
