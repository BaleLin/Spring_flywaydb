package com.oocl.Spring_flywaydb.controller.manyToMany;


import com.oocl.Spring_flywaydb.entities.manyToMany.Groups;
import com.oocl.Spring_flywaydb.repositories.manyToMany.GroupsReository;
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
    @Transactional
    public ResponseEntity save(@RequestBody Groups groups) {
        System.out.println(groups.getUsers());
        groups.getUsers().forEach(users -> users.getGroups().add(groups));
        System.out.println(groups.getUsers());
        groupsReository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    @Transactional
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
