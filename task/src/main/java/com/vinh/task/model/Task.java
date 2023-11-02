package com.vinh.task.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    public int task_id;
    @Column(name = "task_name")
    public String task_name;
    @Column(name = "task_description")
    public String task_description;
    @Column(name = "project_id")
    public int project_id;
    @Column(name = "start_date")
    private Date start_date; // You might want to use the appropriate data type for dates.

    @Column(name = "end_date")
    private Date end_date;
}
