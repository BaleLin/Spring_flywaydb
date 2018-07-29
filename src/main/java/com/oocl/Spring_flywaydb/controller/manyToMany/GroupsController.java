package com.oocl.Spring_flywaydb.controller.manyToMany;


import com.oocl.Spring_flywaydb.controller.dto.manyToMany.GroupsDTO;
import com.oocl.Spring_flywaydb.controller.dto.oneToMany.CompaniesDTO;
import com.oocl.Spring_flywaydb.entities.manyToMany.Groups;
import com.oocl.Spring_flywaydb.entities.oneToMany.Companies;
import com.oocl.Spring_flywaydb.repositories.manyToMany.GroupsReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupsController {
    private GroupsReository groupsReository;
    @Autowired
    GroupsController(GroupsReository groupsReository){
        this.groupsReository =groupsReository;
    }

    @PostMapping("/Groups")
    @Transactional
    public ResponseEntity save(@RequestBody Groups groups) {
       // System.out.println(groups.getUsers());
        groups.getUsers().forEach(users -> users.getGroups().add(groups));
        //System.out.println(groups.getUsers());
        groupsReository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/Groups")
    public List<GroupsDTO> getAllGroups(){
        return groupsReository.findAll().stream().map(item->new GroupsDTO(item)).collect(Collectors.toList());
    }
    @PutMapping("/Groups/{id}")
    @Transactional
    public ResponseEntity updateGroup(@RequestBody Groups groups) {
        groupsReository.save(groups);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @Transactional
    @GetMapping("/Groups/{id}")
    public GroupsDTO findById(@PathVariable("id")Long id){
        Groups one = groupsReository.findById(id).get();
        return new GroupsDTO(one);
    }
    @Transactional
    @DeleteMapping("/Groups/{id}")
    public GroupsDTO delete(@PathVariable("id")Long id){
        Groups one = groupsReository.findById(id).get();
        groupsReository.delete(one);
        return new GroupsDTO(one);
    }
}
