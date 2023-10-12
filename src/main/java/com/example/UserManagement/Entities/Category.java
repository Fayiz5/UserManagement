package com.example.UserManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryid;
    private String categorytitle;
    private String categorydescription;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Post> post;
}
