package com.vinh.project.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    public int project_id;
    @Column(name = "project_name")
    public String project_name;
    @Column(name = "project_description")
    public String project_description;
    @Column(name = "start_date")
    public Date start_date;
    @Column(name = "end_date")
    public Date end_date;
    @Column(name = "group_id")
    public int group_id;
}
