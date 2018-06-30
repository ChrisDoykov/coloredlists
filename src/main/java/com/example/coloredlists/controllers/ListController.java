package com.example.coloredlists.controllers;

import com.example.coloredlists.Repositories.ListRepository;
import com.example.coloredlists.models.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ListController {
@Autowired
    ListRepository listRepository;
//Create a list
    @PostMapping("/list")
    public List createList(@Valid@RequestBody List list){
return listRepository.save(list);
    }


}
