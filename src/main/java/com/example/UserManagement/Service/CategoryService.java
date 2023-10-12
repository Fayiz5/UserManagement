package com.example.UserManagement.Service;

import com.example.UserManagement.dto.Categorydto;
import com.example.UserManagement.dto.Userdto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CategoryService {
    Categorydto create(Categorydto cat);
    Categorydto getbyId(Integer id);

    Categorydto updatebyId(Categorydto cat,Integer id);
    List<Categorydto> getall();
    void deletebyId(Integer id);
}
