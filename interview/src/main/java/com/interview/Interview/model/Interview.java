package com.interview.Interview.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
public class Interview implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "grade")
    @NotNull
    @Min(0)
    @Max(10)
    private double grade;
    @Column(name = "status")
    @NotNull
    @Min(0)
    @Max(1)
    private int status;
    @Column(name = "cv_id")
    private int cv_id;
    @Column(name = "date_feedback")
    private Date date_feedback;
    @Column(name = "question_id")
    private int question_id;
    @Column(name = "time_interview")
    private Date time_interview;

    public Interview(int id, String feedback, double grade, int status, int cv_id, Date date_feedback, int question_id, Date time_interview) {
        this.id = id;
        this.feedback = feedback;
        this.grade = grade;
        this.status = status;
        this.cv_id = cv_id;
        this.date_feedback = date_feedback;
        this.question_id = question_id;
        this.time_interview = time_interview;
    }

    public Interview() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCv_id() {
        return cv_id;
    }

    public void setCv_id(int cv_id) {
        this.cv_id = cv_id;
    }

    public Date getDate_feedback() {
        return date_feedback;
    }

    public void setDate_feedback(Date date_feedback) {
        this.date_feedback = date_feedback;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public Date getTime_interview() {
        return time_interview;
    }

    public void setTime_interview(Date time_interview) {
        this.time_interview = time_interview;
    }
}
