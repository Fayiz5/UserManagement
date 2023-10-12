package com.example.UserManagement.Repository;

import com.example.UserManagement.Entities.Category;
import com.example.UserManagement.Entities.Post;
import com.example.UserManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);

    List<Post>  findByCategory(Category category);
    List<Post> findByTitleContaining(String keyword);
}
