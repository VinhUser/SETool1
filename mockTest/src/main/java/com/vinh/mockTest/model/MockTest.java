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
    @Column(name = "moock_test_id")
    public int moock_test_id;
    @Column(name = "test_name")
    public String test_name;
    @Column(name = "test_description")
    public String test_description;
    @Column(name = "project_id")
    public int project_id;
}
