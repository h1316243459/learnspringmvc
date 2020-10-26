package com.monkey1024.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//写完这个Controller 表示我们这个类是Controller（处理器）这样我们就不用实现哪个controller接口了
@Controller
@RequestMapping("/test")//表示这是一个命名空间namespace
//之前写的下面的mapping 有重复，这样就可以写在上面,下面的就可以删掉
public class HelloSpringMVC02 {

    @RequestMapping(value ="/test2.do",method = RequestMethod.POST)//如果我在 浏览器里面发送了这个请求，我就会用这个方法
    public ModelAndView test1(HttpServletRequest request , HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("hello","test2");
        mv.setViewName("test1");
        return mv;
    }

    @RequestMapping({"/test/hello.do","/test/world.do"})
    //如果我在 浏览器里面输入的url使两个钟的其中一个，就会使用下面方法
    //接受不同url的方法
    public ModelAndView test2(HttpServletRequest request , HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("test","hello world");
        mv.setViewName("test1");
        return mv;
    }
}
