package com.example.UserManagement.Service.Implement;

import com.example.UserManagement.Entities.User;
import com.example.UserManagement.Exception.ResourceNotFoundException;
import com.example.UserManagement.Repository.UserRepository;
import com.example.UserManagement.Service.UserService;
import com.example.UserManagement.dto.Userdto;
import com.example.UserManagement.payloads.PageResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceimp implements UserService {
@Autowired
private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Userdto create(Userdto userdto) {
        User user=this.dtoToUser(userdto);
        User saveuser=userRepository.save(user);
        return this.Usertodto(saveuser);
    }

    @Override
    public Userdto getbyId(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("user","Id",id)));
        return this.Usertodto(user);

    }

    @Override
    public Userdto updatebyId(Userdto userdto, Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("user","Id",id)));
        user.setName(userdto.getName());
        user.setEmail(userdto.getEmail());
        user.setPassword(user.getPassword());
        user.setAbout(user.getAbout());
        User updateduser=userRepository.save(user);
        return this.Usertodto(updateduser);

    }

    @Override
    public List<Userdto> getall() {
       List <User> user=userRepository.findAll();
       List<Userdto> userdtos=user.stream().map(user1 -> this.Usertodto(user1)).collect(Collectors.toList());
        return userdtos;
    }

    @Override
    public void deletebyId(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("user","Id",id)));
        userRepository.delete(user);
    }

    @Override
    public PageResponse getallpage(Integer page, Integer size,String sortby,String sortdir) {
        Sort sort=null;
        if(sortdir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortby).ascending();
        }
        else {
            sort=Sort.by(sortby).descending();
        }
        Page<User> user= userRepository.findAll(PageRequest.of(page,size,sort));

        List<Userdto> userdtos=user.stream().map(user1->Usertodto(user1)).collect(Collectors.toList());
        PageResponse pageResponse=new PageResponse();
        pageResponse.setContent(userdtos);
        pageResponse.setPagenumber(user.getNumber());
        pageResponse.setSize(user.getSize());
        pageResponse.setTotalpage(user.getTotalPages());
        pageResponse.setTotalelements(user.getTotalElements());
        pageResponse.setLastpage(user.isLast());
        return  pageResponse;
    }


    public User dtoToUser(Userdto userdto) {
        User user = modelMapper.map(userdto,User.class);
//        user.setId(userdto.getId());
//        user.setName(userdto.getName());
//        user.setEmail(userdto.getEmail());
//        user.setPassword(userdto.getPassword());
//        user.setAbout(userdto.getAbout());
        return user;
    }
    public Userdto Usertodto(User user){
        Userdto userdto=modelMapper.map(user,Userdto.class);
//        userdto.setId(user.getId());
//        userdto.setName(user.getName());
//        userdto.setEmail(user.getEmail());
//        userdto.setPassword(user.getPassword());
//        userdto.setAbout(user.getAbout());
        return userdto;
    }
}
