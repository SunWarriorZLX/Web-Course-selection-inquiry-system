package com.sunwarriorzlx.webexp.impl;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.StudentDao;
import com.sunwarriorzlx.webexp.entity.Student;
import com.sunwarriorzlx.webexp.service.StudentService;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public String getPasswordByName(String userName) {
        return studentDao.getPasswordByName(userName);
    }

    @Override
    public Student getByName(String userName) {
        return studentDao.getByName(userName);
    }
}