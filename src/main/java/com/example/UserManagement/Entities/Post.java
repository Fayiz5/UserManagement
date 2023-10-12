package com.example.UserManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int post_id;
    private String title;
    private String content;
    private String imagename;
    private Date addeddate;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
