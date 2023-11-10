package com.vinh.group.controller;

import com.vinh.group.entity.Group;
import com.vinh.group.entity.GroupDTO;
import com.vinh.group.repository.GroupRepository;
import com.vinh.group.service.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupServiceImpl groupService;
    @PostMapping("/create")
    public ResponseEntity<?> createGroup(@RequestParam String name, @RequestParam  int studentId) {
        return groupService.createGroup( name,studentId);
    }
    @PostMapping("/{groupId}/add-members")
    public ResponseEntity<?> addMembersToGroup(@RequestParam String name, @RequestBody Integer studentId, @RequestParam Integer leaderId) {
        return groupService.addStudent(name,studentId,leaderId);
    }
    @PutMapping("/{groupId}/update-name")
    public ResponseEntity<String> updateGroupName(@PathVariable Integer groupId, @RequestParam String name) {
        return groupService.upDateGroup( name,groupId );
    }
    @GetMapping("/groups")
    public List<Group> findAllGroup() {
        return groupService.findAllGroup();
    }
    @GetMapping("/findByName")
    public Optional<Group> findGroupsByName(String groupName) {
        return groupService.findGroupsByName(groupName);
    }
    @GetMapping("/group/{groupId}")
    public ResponseEntity<GroupDTO> findGroupById(@PathVariable Integer groupId) {
        GroupDTO groupDTO = groupService.findGroupAndStudentCount(groupId);
        if (groupDTO != null) {
            return new ResponseEntity<>(groupDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @DeleteMapping("/delete/{groupId}")
//    public ResponseEntity<String> deleteGroupById(@PathVariable Integer groupId) {
//        return groupService.deleteGroupById(groupId);
//    }


}