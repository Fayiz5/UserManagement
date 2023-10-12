package com.example.UserManagement.Controller;
import com.example.UserManagement.Service.UserService;
import com.example.UserManagement.dto.Userdto;
import com.example.UserManagement.payloads.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserService userService;
@PostMapping("/user")
    public ResponseEntity<Userdto> create(@Valid @RequestBody Userdto userdto){
        Userdto createddto=userService.create(userdto);

        return new ResponseEntity<>(createddto, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<List<Userdto>> getall(){
        List<Userdto> userdtos=userService.getall();
        return new ResponseEntity<>(userdtos,HttpStatus.FOUND);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Userdto> getbyid(@PathVariable("id")int id){
        Userdto userdto=userService.getbyId(id);
        return new ResponseEntity<>(userdto,HttpStatus.FOUND);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Userdto> delete(@PathVariable("id")int id){
        userService.deletebyId(id);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Userdto> update(@Valid @RequestBody Userdto userdto,@PathVariable("id")int id){
        Userdto userdto1=userService.updatebyId(userdto,id);
        return new ResponseEntity<>(userdto1,HttpStatus.CREATED);
    }
    @GetMapping("/user/page/{page}/{size}/{sortby}/{sortdir}")
    public ResponseEntity<PageResponse> getall(@PathVariable Integer page, @PathVariable Integer size,@PathVariable String sortby,@PathVariable String sortdir){
        PageResponse userdtos=userService.getallpage(page, size,sortby,sortdir);
        return new ResponseEntity<>(userdtos,HttpStatus.FOUND);
    }

}
