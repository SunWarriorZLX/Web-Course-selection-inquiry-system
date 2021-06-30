package com.sunwarriorzlx.webexp.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sunwarriorzlx.webexp.dao.CLassDao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDaoImpl implements CLassDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<String> getClassById(List<String> classId) {
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
        return ret;
    }
}
