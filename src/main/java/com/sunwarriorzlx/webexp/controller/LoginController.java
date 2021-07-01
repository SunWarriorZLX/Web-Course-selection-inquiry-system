package com.sunwarriorzlx.webexp.controller;

import java.util.UUID;

import javax.annotation.Resource;
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
    private UUID uuid;

    @PostMapping(value = "login")
    public Result login(@RequestParam("name") String userName, @RequestParam("password") String password,
            HttpSession httpSession) {
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
        result.setCode(1);
        result.setMsg("登录成功");
        result.setDatas(uuid.randomUUID().toString());
        httpSession.setAttribute(result.getDatas(), System.currentTimeMillis());
        return result;
    }
}