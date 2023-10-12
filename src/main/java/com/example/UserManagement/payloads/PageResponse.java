package com.example.UserManagement.payloads;

import com.example.UserManagement.dto.Postdto;
import com.example.UserManagement.dto.Userdto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {
    private List<Userdto> content;
    private int size;
    private int pagenumber;
    private long totalelements;
    private int totalpage;
    private boolean lastpage;


}
