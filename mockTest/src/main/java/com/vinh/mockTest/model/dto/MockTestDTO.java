package com.vinh.mockTest.model.dto;

import com.vinh.mockTest.model.records.ProjectRecord;
import lombok.*;

import java.io.Serializable;

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
}
