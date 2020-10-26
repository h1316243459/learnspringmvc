package com.monkey1024.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 方法中返回String类型
* 如果你只希望方法执行完毕后跳转jsp或其他资源，此时可以使用String作为方法的返回值
*
* */

@Controller
public class ReturnStringController {
    @RequestMapping("/welcome.do")
    public String welcome()throws Exception{

        return "welcome";
    }


    /*
    * 跳转到外部资源
    * */
    @RequestMapping("/monkey1024.do")
    public String monkey1024()throws Exception{

        //此处返回的字符串需要跟springmvc。xml配置文件中的外部资源view中的bean的id保持一致
        return "monkey1024";
    }
}
