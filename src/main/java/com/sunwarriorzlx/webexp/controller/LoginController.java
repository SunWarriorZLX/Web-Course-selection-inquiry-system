package com.sunwarriorzlx.webexp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunwarriorzlx.webexp.service.StudentService;
import com.sunwarriorzlx.webexp.util.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoginController
 */
@RestController
public class LoginController {
    @Resource
    private StudentService studentService;

    @PostMapping(value = "login")
    public Result<String> login(@RequestParam(value = "name", required = true) String userName,
            @RequestParam(value = "password", required = true) String password, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        Result<String> result = new Result<String>();
        String pass = studentService.getPasswordByName(userName);
        if (pass == null) {
            result.setCode(0);
            result.setMsg("用户名不存在");
            return result;
        } else if (!pass.equals(password)) {
            result.setCode(0);
            result.setMsg("密码错误");
            return result;
        }
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("userName", userName);
        // cookie = new Cookie("loginSESSION", httpSession.getId());
        // cookie.setMaxAge(httpSession.getMaxInactiveInterval());
        // httpServletResponse.addCookie(cookie);
        result.setCode(1);
        result.setMsg("登录成功");
        return result;
    }
}