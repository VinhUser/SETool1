package com.vinh.result.model.record;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MockTestRecord {
    private String test_name;
    private String test_description;
    private ProjectRecord project;

    // Các getter và setter cho các trường

    // Getter cho test_name
    public String getTest_name() {
        return test_name;
    }

    // Setter cho test_name
    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    // Getter cho test_description
    public String getTest_description() {
        return test_description;
    }

    // Setter cho test_description
    public void setTest_description(String test_description) {
        this.test_description = test_description;
    }

    // Getter cho project
    public ProjectRecord getProject() {
        return project;
    }

    // Setter cho project
    public void setProject(ProjectRecord project) {
        this.project = project;
    }
}







