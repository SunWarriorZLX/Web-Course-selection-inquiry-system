package com.sunwarriorzlx.webexp.dao;

import com.sunwarriorzlx.webexp.entity.Student;

public interface StudentDao {
    Student getByName(String userName);

    String getPasswordByName(String userName);
}
