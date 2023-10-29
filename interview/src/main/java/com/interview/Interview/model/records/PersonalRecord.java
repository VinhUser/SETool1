package com.interview.Interview.model.records;

import jakarta.persistence.Column;

import java.util.Date;

public record PersonalRecord( //get date form personal, auto map

        String address,
        String email,
        String fullName,
        int gender,
        String phone

) {
}
