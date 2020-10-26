package com.monkey1024.controller;


/*
* 方法没有返回值
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReturnVoidController {

    @RequestMapping("/servletjump.do")
    public void servletJump(HttpServletRequest request,HttpServletResponse response)throws Exception{
        request.getRequestDispatcher("/jsp/welcome.jsp").forward(request,response);
    }

}
