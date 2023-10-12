package com.example.UserManagement.Service.Implement;

import com.example.UserManagement.Entities.Category;
import com.example.UserManagement.Entities.Post;
import com.example.UserManagement.Entities.User;
import com.example.UserManagement.Exception.ResourceNotFoundException;
import com.example.UserManagement.Repository.CategoryRepository;
import com.example.UserManagement.Repository.PostRepository;
import com.example.UserManagement.Repository.UserRepository;
import com.example.UserManagement.Service.PostService;
import com.example.UserManagement.dto.Postdto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostImp implements PostService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Postdto create(Postdto postdto,Integer userid,Integer catid) {
        Post post=modelMapper.map(postdto,Post.class);
        User user=userRepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("User","Id",userid));
        Category category=categoryRepository.findById(catid).orElseThrow(()->new ResourceNotFoundException("category","id",catid));
        post.setImagename("default.png");
        post.setCategory(category);
        post.setUser(user);
        post.setAddeddate(new Date());
        Post savepost=postRepository.save(post);
        return modelMapper.map(savepost,Postdto.class);
    }

    @Override
    public Postdto getbyId(Integer id)
    {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","Id",id));
        Postdto postdto=modelMapper.map(post,Postdto.class);
        return postdto;
    }

    @Override
    public Postdto updatebyId(Postdto postdto, Integer id) {
        Post post=modelMapper.map(postdto,Post.class);
        post.setTitle(postdto.getTitle());
        post.setContent(postdto.getContent());
        post.setAddeddate(postdto.getAddeddate());
        Post updated=postRepository.save(post);
        return modelMapper.map(updated,Postdto.class);
    }

    @Override
    public List<Postdto> getall() {
        List<Post> getpost=postRepository.findAll();
        List<Postdto> getpostdto=getpost.stream().map((post)-> modelMapper.map(post,Postdto.class)).collect(Collectors.toList());
        return getpostdto;
    }

    @Override
    public void deletebyId(Integer id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","PostId",id));
        postRepository.delete(post);
    }

    @Override
    public List<Postdto> findbyUser(Integer id) {
        User user= userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        List<Post>posts=postRepository.findByUser(user);
        List<Postdto> postdtos=posts.stream().map((post)-> modelMapper.map(post,Postdto.class)).collect(Collectors.toList());
        return postdtos;
    }

    @Override
    public List<Postdto> findbyCategory(Integer id) {
        Category category=categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","Id",id));
        List<Post> posts=postRepository.findByCategory(category);
        List<Postdto> postdtos=posts.stream().map((post)-> modelMapper.map(post,Postdto.class)).collect(Collectors.toList());
        return postdtos;
    }

    @Override
    public List<Postdto> searchbytitle(String title) {
        List<Post> posts=postRepository.findByTitleContaining(title);
        return posts.stream().map((post->modelMapper.map(post,Postdto.class))).collect(Collectors.toList());
    }
}
