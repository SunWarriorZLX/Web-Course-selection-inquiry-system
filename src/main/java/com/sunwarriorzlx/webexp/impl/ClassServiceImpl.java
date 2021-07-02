package com.sunwarriorzlx.webexp.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.CLassDao;
import com.sunwarriorzlx.webexp.service.ClassService;

import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Resource
    private CLassDao cLassDao;

    public List<String> getClassById(List<String> classId) {
        return cLassDao.getClassById(classId);
    }
}
