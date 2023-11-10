package com.vinh.group.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "is_leader")
    private boolean isLeader = false;

    @ManyToMany(cascade = CascadeType.ALL)
//    Set<Group> GroupUser;
    @JoinTable(name = "groupuser",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "group_id"))
    @JsonManagedReference
    private Set<Group> studentgroup;
    public User(boolean isLeader) {
        this.isLeader = isLeader;
    }


}






