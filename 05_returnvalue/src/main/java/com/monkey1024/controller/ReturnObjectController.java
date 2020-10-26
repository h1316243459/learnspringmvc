package com.monkey1024.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnObjectController {


    //返回字符串
    @RequestMapping(name = "/returnString ",produces = "text/html;charset=uft-8")
    //防止中文乱码
    @ResponseBody//将返回值返回到响应体中；如果没有这个注解就会去找相应的jsp
    public Object returnString()throws Exception{
        return "monkey1024";
    }



    //返回map类型
    @RequestMapping("/returnMap.do")
    @ResponseBody
    public Object returnMap() throws Exception{
        Map<String ,String> map = new HashMap<>();
        map.put("hello","你好");
        map.put("world","世界");

        return  map;
    }
}
