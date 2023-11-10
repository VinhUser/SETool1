package com.vinh.group.service;

import com.vinh.group.entity.Group;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    ResponseEntity<?> addStudent(String name, int studentId, int leaderId);
    ResponseEntity<?> createGroup(String name, int studentId);
    ResponseEntity<String> upDateGroup(String name, Integer groupId);
    Optional<Group> findGroupsByName(String groupName);
    Group findGroupById(Integer groupId);
    List<Group> findAllGroup();
    // ResponseEntity<String> deleteGroupById(Integer groupId);

}