package com.sunwarriorzlx.webexp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.sunwarriorzlx.webexp.dao.StudentDao;
import com.sunwarriorzlx.webexp.entity.Student;
import com.sunwarriorzlx.webexp.service.StudentService;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@SpringBootTest
class WebexpApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Resource
    private StudentService studentService;
    @Resource
    private StudentDao studentDao;

    @Test
    void contextLoads() {
    }

    @Test
    public void insertTest() {
        String sql = "insert into STUDENT_CLASS (USERID,CLASSID,REGTIME,GRADE) values ('210','J02',DEFAULT,null)";
        jdbcTemplate.update(sql);
    }

    @Test
    public void selectTest() {
        String userName = "210";
        String sql = "select PASSWORD from STUDENT where USERNAME = ?";
        this.jdbcTemplate.queryForObject(sql, new Object[] { userName }, String.class);
        // this.jdbcTemplate.queryForObject("select PASSWORD from STUDENT where USERNAME
        // = 's210'", String.class);
        // List<String> ret = this.jdbcTemplate.query(sql, new Object[] { userName },
        // new SingleColumnRowMapper<>(String.class));
        return;
    }

    @Test
    public void getByName() {
        String sql = "select * from STUDENT where USERNAME = ?";
        String userName = "s210";
        Student student;
        student = this.jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
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
        return;
    }

    @Test
    public void getClassById() {
        List<String> classId = new LinkedList<>();
        classId.add("J01");
        classId.add("J02");
        String sql = "select CLASSNAME from CLASS where CLASSID in (:ClassIds)";
        List<String> ret;
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("ClassIds", classId);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        try {
            ret = namedParameterJdbcTemplate.queryForList(sql, mapSqlParameterSource, String.class);
        } catch (DataAccessException e) {
            ret = null;
        }
        return;
    }

    @Test
    public void studentService() {
        // String pass = studentService.getPasswordByName("s201");
        // String pass = studentDao.getPasswordByName("s201");
        String userName = "s201";
        String sql = "select PASSWORD from STUDENT where USERNAME = ?";
        String pass = this.jdbcTemplate.queryForObject(sql, new Object[] { userName }, String.class);
        return;
    }

}
