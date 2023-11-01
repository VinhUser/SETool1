package com.vinh.project.model.dto;

import com.vinh.project.model.record.GroupRecord;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO implements Serializable {
    private int project_id;
    public String project_name;
    public String project_description;
    public Date start_date;
    public Date end_date;
    public int group_id;

}
