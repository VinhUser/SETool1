package com.vinh.mockTest.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "moocktest")

public class MockTest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MoockTestId")
    private int moockTestId;
    @Column(name = "TestName")
    private String testName;
    @Column(name = "TestDescription")
    private String testDescription;
    @Column(name = "ProjectId")
    private int projectId;
}
