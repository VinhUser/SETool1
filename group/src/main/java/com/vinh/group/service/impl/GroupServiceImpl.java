package com.vinh.group.service.impl;

import com.vinh.group.entity.Group;
import com.vinh.group.entity.GroupDTO;
import com.vinh.group.entity.User;
import com.vinh.group.repository.GroupRepository;
import com.vinh.group.repository.UserRepository;
import com.vinh.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    public GroupDTO findGroupAndStudentCount(int groupId) {
        return groupRepository.findById(groupId)
                .map(this::convertToGroupDto)
                .orElseThrow(() -> new NoSuchElementException("Group not found with id: " + groupId));
    }
    public GroupDTO convertToGroupDto(Group group) {
        GroupDTO dto = new GroupDTO();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setProjectManager(group.getProjectManager());
        dto.setStudentCount(group.getNumberOfStudents()); // Thêm số lượng thành viên vào DTO
        return dto;
    }
    @Override
    public ResponseEntity<?> addStudent(String name, int studentId, int leaderId) {
        Group group = groupRepository.findByName(name).orElseThrow(() -> new RuntimeException("Not Fold"));
        User user = userRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Not Fold"));
        User leader = userRepository.findById(leaderId).orElseThrow(()-> new RuntimeException("Not Fold"));
        if(leader.isLeader()==false){
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).body("You ARE Not Leader");
        }
        if(group.getStudent().size()>5){
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).body("Group Full Student");
        }
        group.getStudent().add(user);
        groupRepository.save(group);

        return ResponseEntity.status( HttpStatus.OK).body("success");
    }

    @Override
    public ResponseEntity<?> createGroup(String name, int studentId) {
        Group group = groupRepository.findByName(name).orElseThrow(() -> new RuntimeException("Same name"));
        if(group.getStudent().size()>=5){
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).body("Maxximun Group 5 stundent");
        }
        groupRepository.save(group);
        return ResponseEntity.status(HttpStatus.OK).body("success to create group");
    }
    @Override
    public ResponseEntity<String> upDateGroup(String name, Integer groupId) {
        Group group = groupRepository.findById( groupId ).orElseThrow( null );
        if (group.getName() != null) {

            if (groupRepository.existsByNameAndIdNot(name, groupId)) {throw new RuntimeException("Name GroupExit");
            }
            group.setName(name);
            groupRepository.save(group);
        }
        return ResponseEntity.status(HttpStatus.OK).body("update name success");
    }
    @Override
    public Optional<Group> findGroupsByName(String groupName) {
        return groupRepository.findGroupsByName( groupName );
    }
    @Override
    public Group findGroupById(Integer groupId) {
        return groupRepository.findById( groupId ).orElse( null );
    }
    @Override
    public List<Group> findAllGroup() {
        return groupRepository.findAll();
    }

//    @Override
//    public ResponseEntity<String> deleteGroupById(Integer groupId) {
//       Group group = groupRepository.findById( groupId ).orElse( null );
//        if(group == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group not found with ID: " + groupId);
//        }
//        groupRepository.delete(group);
//        return ResponseEntity.status(HttpStatus.OK).body("Group deleted successfully.");
//
//    }


}