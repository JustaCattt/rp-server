package com.example.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dormitory {

    private String id;
    private String build;
    private String room;
    private String resident;
    private String stuId;
}
