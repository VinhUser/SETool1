package com.vinh.submissionTest.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="submissiontask")
public class SubmissionTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submission_task_id")
    private int submission_task_id;
    @Column(name = "task_id")
    private int task_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "Submission_date")
    public Date Submission_date;
    @Column(name = "content")
    public String content;
}
