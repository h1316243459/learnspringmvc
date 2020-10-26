package com.monkey1024.controller;

/*
* spring mvc中的转发和重定向
* */

import com.monkey1024.bean.School;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForwardRedirectController {

    @RequestMapping("/forwardMAV.do")
    public ModelAndView forwardMAV()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("type","返回ModelAndView对象的转发");
        //默认使用转发来进行跳转
       // mv.setViewName("/result");
       // mv.setViewName("forward:/jsp/result.jsp");//手动显示的指定使用转发，此时视图解析器将会失效

        mv.setViewName("forward:other.do");//跳转到其他Controller上了，并且其type数据也传递过去了
        return mv;
    }



    //被跳转的Controller

    @RequestMapping("/other.do")
    public ModelAndView other()throws Exception{

        ModelAndView mv = new ModelAndView();
        mv.addObject("content","被跳转的controller");
        mv.setViewName("result");

        return mv;
    }
    
    
    //重定向到其他jsp中
    @RequestMapping("/rediectMAV.do")
    public ModelAndView redirectMAV()throws Exception{
        ModelAndView mv = new ModelAndView();
        //这里只能传递基本数据类型和String类型 像什么自定义类型School，Student类型都不行
        mv.addObject("type","返回ModelAndView对象的重定向");

        //重定向
        mv.setViewName("redirect:/jsp/result.jsp");
        return mv;
    }




    //重定向到其他Controller中
    @RequestMapping("/redirectOther.do")
    public ModelAndView redirectOther()throws Exception{
        ModelAndView mv = new ModelAndView();

        mv.addObject("content","返回ModelAndView对象的重定向,跳转到其他Controller");
        mv.addObject("school","清华");
        mv.addObject("address","北京");

        //重定向
        mv.setViewName("redirect:other1.do");
        return mv;
    }


    @RequestMapping("/other1.do")
    public ModelAndView other1(String type, School school)throws Exception{

        ModelAndView mv = new ModelAndView();
        mv.addObject("content","被跳转的controller");
        //参数的数据添加到mv中
        mv.addObject("type",type);
        mv.addObject("school",school);

        mv.setViewName("result");

        return mv;
    }

    /*
    返回String类型的转发
    * */
    @RequestMapping("/forwardStr.do")
    //方法中的参数会自动放到request中
    public String forwardStr(School school)throws  Exception{


        return "forward:/jsp/result.jsp";
    }


    /*
   返回String类型的重定向
   * */
    @RequestMapping("/redirectStr.do")
    //因为是重定向，所以在request数据域是不共享的，所以要个Model，把数据放在Model中
    //因为数据会被放到url地址栏中
    //这里只能传递基本数据类型和String类型 像什么自定义类型School，Student类型都不行
    public String redirectStr(Model model,School school)throws  Exception{
        model.addAttribute("school",school.getSchool());
        model.addAttribute("address",school.getAddress());

        return "forward:/jsp/result.jsp";
    }
}
