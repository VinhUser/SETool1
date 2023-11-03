package com.vinh.result.model.dto;

import com.vinh.result.model.record.MockTestRecord;
import com.vinh.result.model.record.ProjectRecord;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO implements Serializable {
    private int resultId;
    private String Comment;
    private MockTestRecord mockTest;


}
