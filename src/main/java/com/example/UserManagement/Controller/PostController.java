package com.example.UserManagement.Controller;

import com.example.UserManagement.Service.PostService;
import com.example.UserManagement.dto.Categorydto;
import com.example.UserManagement.dto.Postdto;
import com.example.UserManagement.dto.Userdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    public PostService postService;
    @PostMapping("/user/{uid}/category/{catid}/post")
    public ResponseEntity<Postdto> create(@Valid @RequestBody Postdto postdto, @PathVariable Integer uid, @PathVariable Integer catid){
       Postdto createpost=postService.create(postdto,uid,catid);
       return new ResponseEntity<>(createpost, HttpStatus.CREATED);
   }

   @GetMapping("/user/{userid}/post")
    public ResponseEntity<List<Postdto>> getbyUser(@PathVariable Integer userid){
        List<Postdto> getpost=postService.findbyUser(userid);
        return new ResponseEntity<>(getpost,HttpStatus.FOUND);
   }
    @GetMapping("/category/{cid}/post")
    public ResponseEntity<List<Postdto>> getbyCat(@PathVariable Integer cid){
        List<Postdto> getpost=postService.findbyCategory(cid);
        return new ResponseEntity<>(getpost,HttpStatus.FOUND);
    }
    @GetMapping("/post")
    public ResponseEntity<List<Postdto>> getallpost(){
        List<Postdto> gtall=postService.getall();
        return new ResponseEntity<>(gtall,HttpStatus.FOUND);
    }
    @GetMapping("/post/{id}")
    public ResponseEntity<Postdto> getpostbyid(@PathVariable Integer id){
        Postdto postdto=postService.getbyId(id);
        return new ResponseEntity<>(postdto,HttpStatus.FOUND);
    }
    @PutMapping("/post/{id}")
    public ResponseEntity<Postdto> updated(@Valid @RequestBody Postdto postdto,@PathVariable Integer id){
        Postdto postdto1=postService.updatebyId(postdto,id);
        return new ResponseEntity<>(postdto1,HttpStatus.CREATED);
    }
    @GetMapping("/posts/{title}")
    public ResponseEntity<List<Postdto>> search(@PathVariable String title){
        List<Postdto> postdtos=postService.searchbytitle(title);
        return new ResponseEntity<>(postdtos,HttpStatus.FOUND);
    }
}

