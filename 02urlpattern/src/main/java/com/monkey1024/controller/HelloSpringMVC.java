package com.monkey1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//写完这个Controller 表示我们这个类是Controller（处理器）这样我们就不用实现哪个controller接口了
@Controller
public class HelloSpringMVC {

    @RequestMapping("/test/test1.do")//如果我在 浏览器里面发送了这个请求，我就会用这个方法
    public ModelAndView test1(HttpServletRequest request , HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello","hello first spring mvc");
        mv.setViewName("first");
        return mv;
    }
}
