package com.vinh.mockTest.model.dto;

import com.vinh.mockTest.model.records.ProjectRecord;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MockTestDTO {
    private int moockTestId;
    private String testName;
    private String testDescription;
    private ProjectRecord project;
}
