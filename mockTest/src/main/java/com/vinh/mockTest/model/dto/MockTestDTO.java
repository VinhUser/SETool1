package com.vinh.mockTest.model.dto;

import com.vinh.mockTest.model.records.ProjectRecord;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MockTestDTO implements Serializable {
    private int moock_test_id;
    public String test_name;
    public String test_description;
    public ProjectRecord project;
    public Date start_date;
    public Date end_date;
    private String message;

    // Các phương thức getter và setter cho trường message

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
