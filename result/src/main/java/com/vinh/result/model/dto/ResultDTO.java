package com.vinh.result.model.dto;

import com.vinh.result.model.record.MockTestRecord;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {
    private int resultId;

    private String Comment;

    private MockTestRecord mockTest;
}
