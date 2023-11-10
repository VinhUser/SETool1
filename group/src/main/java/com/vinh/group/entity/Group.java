package com.vinh.group.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "group1")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer id;

    @Column(name = "group_name")
    private String name;

    @Column(name = "project_manager")
    private Integer projectManager;

   @ManyToMany(mappedBy = "studentgroup")
    @JsonBackReference
   private Set<User> student;

    public int getNumberOfStudents() {
        return this.student != null ? this.student.size() : 0;
    }

}
