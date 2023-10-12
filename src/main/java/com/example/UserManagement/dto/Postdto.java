package com.example.UserManagement.dto;

import com.example.UserManagement.Entities.Category;
import com.example.UserManagement.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Postdto {

    private String title;
    private String content;
    private String imagename;
    private Date addeddate;
    private Userdto user;
    private Categorydto category;
}
