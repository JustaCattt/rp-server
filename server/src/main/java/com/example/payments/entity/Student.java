package com.example.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String id;
    private String name;
    private String stuId;
    private String grade;
    private String major;
    private String college;
    private String claSs;    //班级 因为类也叫class
}
