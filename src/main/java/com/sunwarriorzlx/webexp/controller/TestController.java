package com.sunwarriorzlx.webexp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "service")
public class TestController {
    @RequestMapping("getMsg")
    public String getMsg(HttpSession session) {

        String msg = (String) session.getAttribute("msg");
        return msg;
    }
}
