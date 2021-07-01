package com.sunwarriorzlx.webexp.util;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T datas;
}
