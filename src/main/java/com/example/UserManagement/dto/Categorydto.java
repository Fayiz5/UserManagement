package com.example.UserManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Categorydto {
    private int categoryid;
    @NotEmpty
    private String categorytitle;
    @NotEmpty
    private String categorydescription;
}
