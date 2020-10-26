package com.monkey1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * 文件上传
 */
@Controller
public class UploadController {

    /**
     * 处理单个文件上传
     *
     * @param photo
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload1.do")
    public ModelAndView upload1(MultipartFile photo, HttpSession session) throws Exception {

        ModelAndView mv = new ModelAndView();

        //判断用户是否上传了文件
        if (!photo.isEmpty()) {
            //获取服务器中文件上传的路径
            String path = session.getServletContext().getRealPath("/upload");

            //获取文件上传的名称
            String fileName = photo.getOriginalFilename();

            System.out.println(fileName);

            //限制文件上传的类型
            if ("image/png".equals(photo.getContentType())) {
                File file = new File(path, fileName);

                //完成文件上传
                photo.transferTo(file);
            } else {
                mv.addObject("msg", "请选择png格式的图片上传");
                mv.setViewName("/upload_fail");

                return mv;
            }
        } else {
            mv.addObject("msg", "请上传一张png个的图片");
            mv.setViewName("/upload_fail");

            return mv;
        }

        //跳转到成功页面
        mv.setViewName("/upload_success");

        return mv;
    }


    /**
     * 处理多个文件上传
     * @param photos
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload2.do")
    public ModelAndView upload2(@RequestParam MultipartFile[] photos, HttpSession session) throws Exception{
        ModelAndView mv = new ModelAndView();

        //获取服务器中文件上传的路径
        String path = session.getServletContext().getRealPath("/upload");

        //遍历MultipartFile数组
        for (MultipartFile photo:photos){
            //判断用户是否上传了文件
            if (!photo.isEmpty()){

                //获取文件上传的名称
                String fileName = photo.getOriginalFilename();

                System.out.println(fileName);

                //限制文件上传的类型
                if ("image/png".equals(photo.getContentType())){
                    File file = new File(path, fileName);

                    //完成文件上传
                    photo.transferTo(file);
                }else {
                    mv.addObject("msg", "请选择png格式的图片上传");
                    mv.setViewName("/upload_fail");

                    return mv;
                }
            }else{
                mv.addObject("msg", "请上传一张png个的图片");
                mv.setViewName("/upload_fail");

                return mv;
            }
        }




        //跳转到成功页面
        mv.setViewName("/upload_success");

        return mv;
    }
}
