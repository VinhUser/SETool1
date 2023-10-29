package com.interview.Interview.model.dto;

import com.interview.Interview.model.records.CvRecord;
import com.interview.Interview.model.records.QuestionRecord;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InterviewDTO implements Serializable {
    private int id;
    public String feedback;
    public double grade;
    public int status;
    public Date date_feedback;
    public Date time_interview;
    public QuestionRecord question;
    public CvRecord cv;


}
