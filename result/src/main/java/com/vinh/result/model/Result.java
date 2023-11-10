package com.vinh.result.model;

import com.vinh.result.client.ProjectClient;
import com.vinh.result.model.record.MockTestRecord;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    public int result_id;
    @Column(name = "comment")
    public String comment;
    @JoinColumn(name = "mock_test_id")
    public int mock_test_id;


}
