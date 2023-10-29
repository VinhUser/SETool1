package com.vinh.result.model;

import com.vinh.result.model.record.MockTestRecord;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "result")
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResultId")
    private int resultId;
    @Column(name = "Comment")
    private String Comment;
    @Column(name = "MockTest")
    private int mockTestId;
}
