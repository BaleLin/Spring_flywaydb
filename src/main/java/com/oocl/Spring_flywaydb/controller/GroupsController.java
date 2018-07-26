package com.oocl.Spring_flywaydb.controller;


import com.oocl.Spring_flywaydb.entities.Groups;
import com.oocl.Spring_flywaydb.repositories.GroupsReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
public class GroupsController {
    private GroupsReository groupsReository;
    @Autowired
    GroupsController(GroupsReository groupsReository){
        this.groupsReository =groupsReository;
    }

    @PostMapping
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity save(@RequestBody Groups groups) {
        groups.getUsers().forEach(users -> users.getGroups().add(groups));
        groupsReository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity updateGroup(@RequestBody Groups groups) {
        groupsReository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//    @Transactional
//    @GetMapping("/Groups/{id}")
//    public GroupsDTO findById(@PathVariable("id")Long id){
//        Groups one = groupsReository.findById(id).get();
//        return new GroupsDTO(one);
//    }
}
