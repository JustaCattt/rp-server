package com.example.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {
    private Boolean state = true;
    private String msg;
    private String userId;
    private String stuId;
    private Student stuInfo;
    private Payments payInfo;
    private Dormitory dormInfo;
    private Payer payerInfo;
    private List<Payer> payerInfoList;
    private Registrar regInfo;
    private List<Registrar> regInfoList;
    private List<Student> stuInfoList;
}
