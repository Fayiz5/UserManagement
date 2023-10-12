package com.example.UserManagement.Repository;

import com.example.UserManagement.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
