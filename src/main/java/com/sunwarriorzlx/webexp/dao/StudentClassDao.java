package com.sunwarriorzlx.webexp.dao;

import java.util.List;

import com.sunwarriorzlx.webexp.entity.StudentClass;

public interface StudentClassDao {
    // public StudentClass getByStudentIdAndClassId(String id);

    List<String> getClassIdListById(String id);
}
