package com.monkey1024.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//获取url中的数据
//Pathvariable
@Controller
public class PathController01 {
    @RequestMapping("/{username}/{age}/path.do")
    public ModelAndView getPath(@PathVariable("username") String name,@PathVariable int age) throws Exception{
        //方法的参数名必须要跟前台页面的表单里面的参数一致
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",name);
        mv.addObject("age",age);
        mv.setViewName("result");
        return mv;
    }
}
