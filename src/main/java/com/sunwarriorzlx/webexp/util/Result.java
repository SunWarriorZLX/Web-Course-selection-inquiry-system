package com.sunwarriorzlx.webexp.util;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T datas;
}
