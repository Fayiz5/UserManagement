package com.example.UserManagement.Repository;

import com.example.UserManagement.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
