package com.sunwarriorzlx.webexp.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student implements Serializable {
    private String userId;
    private String userName;
    private String password;
    private String sex;
    private String birthday;
    private String regTime;
    private String specialty;
    private String remark;
}
