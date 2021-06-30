package com.sunwarriorzlx.webexp.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.StudentClassDao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentClassDaoImpl implements StudentClassDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getClassIdListById(String userId) {
        String sql = "select CLASSID from STUDENT_CLASS where USERID = ?";
        List<String> ret;
        try {
            ret = jdbcTemplate.queryForList(sql, String.class, new Object[] { userId });
        } catch (DataAccessException e) {
            return null;
        }
        return ret;
    }
}
