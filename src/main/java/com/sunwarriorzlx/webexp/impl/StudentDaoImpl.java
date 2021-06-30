package com.sunwarriorzlx.webexp.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.StudentDao;
import com.sunwarriorzlx.webexp.entity.Student;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public Student getByName(String userName) {
        String sql = "select * from STUDENT where USERNAME = ?";
        Student ret;
        try {
            ret = this.jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                    Student student = new Student();
                    student.setUserId(resultSet.getString("USERID"));
                    student.setUserName(resultSet.getString("USERNAME"));
                    student.setPassword(resultSet.getString("PASSWORD"));
                    student.setSex(resultSet.getString("SEX"));
                    student.setBirthday(resultSet.getString("BIRTHDAY"));
                    student.setRegTime(resultSet.getString("REGTIME"));
                    student.setSpecialty(resultSet.getString("SPECIALTY"));
                    student.setRemark(resultSet.getString("REMARK"));
                    return student;
                }
            }, userName);
        } catch (DataAccessException e) {
            ret = null;
        }
        return ret;
    }

    @Override
    public String getPasswordByName(String userName) {
        String sql = "select PASSWORD from student where USERNAME = ?";
        String pass;
        try {
            pass = this.jdbcTemplate.queryForObject(sql, String.class, userName);
        } catch (DataAccessException e) {
            pass = null;
        }
        return pass;
    }

}
