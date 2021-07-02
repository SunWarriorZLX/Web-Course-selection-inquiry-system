package com.sunwarriorzlx.webexp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.sunwarriorzlx.webexp.entity.Student;
import com.sunwarriorzlx.webexp.service.ClassService;
import com.sunwarriorzlx.webexp.service.StudentClassService;
import com.sunwarriorzlx.webexp.service.StudentService;
import com.sunwarriorzlx.webexp.util.Result;
import com.sunwarriorzlx.webexp.util.UserInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomePageController {
    @Resource
    private StudentService studentService;
    @Resource
    private StudentClassService studentClassService;
    @Resource
    private ClassService classService;

    @GetMapping(value = "homePage")
    public Result<UserInfo> getInfo(HttpServletRequest httpServletRequest) {
        String userName = (String) httpServletRequest.getSession().getAttribute("userName");
        Student student;
        Result<UserInfo> result = new Result<UserInfo>();
        if (userName == null) {
            result.setCode(0);
            result.setMsg("未登录或登录已过期，请重新登录");
            return result;
        }
        student = studentService.getByName(userName);
        if (student == null) {
            result.setCode(0);
            result.setMsg("未知错误");
            return result;
        }
        UserInfo userInfo = new UserInfo();
        result.setCode(1);
        userInfo.setUserName(userName);
        userInfo.setPassword(student.getPassword());
        result.setDatas(userInfo);
        return result;
    }

    @GetMapping(value = "getCourseList")
    public Result<List<String>> getCourseList(HttpServletRequest httpServletRequest) {
        String userName = (String) httpServletRequest.getSession().getAttribute("userName");
        Student student;
        Result<List<String>> result = new Result<List<String>>();
        if (userName == null) {
            result.setCode(0);
            result.setMsg("未登录或登录已过期，请重新登录");
            return result;
        }
        student = studentService.getByName(userName);
        if (student == null) {
            result.setCode(0);
            result.setMsg("未知错误");
            return result;
        }
        String studentId = student.getUserId();
        List<String> classIdList = studentClassService.getClassIdListById(studentId);
        result.setDatas(classService.getClassById(classIdList));
        result.setCode(1);
        return result;
    }

    @GetMapping(value = "logout")
    public Result<String> logout(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getSession().getAttribute("userName") != null) {
            httpServletRequest.getSession().removeAttribute("userName");
        }
        return new Result<String>(1, "用户已登出", null);
    }

}
