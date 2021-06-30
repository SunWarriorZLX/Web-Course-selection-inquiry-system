package com.sunwarriorzlx.webexp.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentClass implements Serializable {
    private String userId;
    private String classId;
    private String regTime;
    private String grade;
}
