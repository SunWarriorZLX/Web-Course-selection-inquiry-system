package com.sunwarriorzlx.webexp.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.StudentClassDao;
import com.sunwarriorzlx.webexp.service.StudentClassService;

public class StudentClassServiceImpl implements StudentClassService {
    @Resource
    private StudentClassDao studentClassDao;

    public List<String> getClassIdListById(String id) {
        return studentClassDao.getClassIdListById(id);
    }
}
