package com.monkey1024.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* model接口，可以用来传递数据
* */
@Controller
public class ModelController {
    @RequestMapping("/modeldata.do")
    public String ModelData(Model model,String name) throws  Exception{
      //  Model model = new Model() ;
        // 因为Model类型springmvc自己自动给你赋值了，只需要参数里带有就行，直接用

        model.addAttribute("username" ,name);//自己取名字
        model.addAttribute(name);
        //类似于model.addAttribute("string",name)    根据你传入值的类型来命名的，系统自己给你的名字
        return "welcome";
    }

}
