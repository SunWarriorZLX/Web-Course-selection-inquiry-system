package com.sunwarriorzlx.webexp.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Class implements Serializable {
    private String classId;
    private String className;
    private String regTime;
    private String specialty;
    private String remark;
}
