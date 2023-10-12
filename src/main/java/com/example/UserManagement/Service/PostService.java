package com.example.UserManagement.Service;

import com.example.UserManagement.dto.Categorydto;
import com.example.UserManagement.dto.Postdto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PostService {
    Postdto create(Postdto postdto,Integer userid,Integer catid);
    Postdto getbyId(Integer id);

    Postdto updatebyId(Postdto postdto,Integer id);
    List<Postdto> getall();
    void deletebyId(Integer id);

    List <Postdto> findbyUser(Integer id);
    List<Postdto> findbyCategory(Integer id);

    List<Postdto> searchbytitle(String title);
}
