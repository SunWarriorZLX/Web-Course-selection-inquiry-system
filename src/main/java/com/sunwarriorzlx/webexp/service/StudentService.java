package com.sunwarriorzlx.webexp.service;

import com.sunwarriorzlx.webexp.entity.Student;

public interface StudentService {
    String getPasswordByName(String userName);

    Student getByName(String userName);
}
