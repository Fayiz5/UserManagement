package com.example.UserManagement.Service;

import com.example.UserManagement.dto.Userdto;
import com.example.UserManagement.payloads.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    Userdto create(Userdto user);
    Userdto getbyId(Integer id);

    Userdto updatebyId(Userdto user,Integer id);
    List<Userdto> getall();
    void deletebyId(Integer id);

    PageResponse getallpage(Integer page, Integer size,String sortby,String sortdir);
}
