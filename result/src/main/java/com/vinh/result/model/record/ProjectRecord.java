package com.vinh.result.model.record;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ProjectRecord {
    private int project_id;
    private String project_name;
    private String project_description;

    // Các getter và setter cho các trường

    // Getter cho project_id
    public int getProject_id() {
        return project_id;
    }

    // Setter cho project_id
    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}






