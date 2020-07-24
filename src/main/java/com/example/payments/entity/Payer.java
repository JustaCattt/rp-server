package com.example.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payer {

    private String id;
    private String userId;
    private String username;
    private String stuId;
    private String realName;
}
