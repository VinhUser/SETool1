package com.vinh.group.repository;

import com.vinh.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    Optional<Group> findByName(String name);
    boolean existsByNameAndIdNot(String name, Integer groupId);
    Optional<Group> findGroupsByName(String groupName);
    List<Group>findAll();

    // Optional<Group> deleteGroupById(Integer groupId);

}