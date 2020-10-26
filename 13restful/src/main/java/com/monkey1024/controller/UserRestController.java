package com.monkey1024.controller;

/*
*  基于restful风格的增删改查实例
* */

import com.alibaba.fastjson.JSON;
import com.monkey1024.bean.User;
import com.monkey1024.util.DataUtil;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserRestController {
    /*
    * 查询所有用户*/
    @GetMapping("/users")
    public  String findAll() throws Exception{
        HashMap<String, User> allUser = DataUtil.findAll();

        return  JSON.toJSONString(allUser);
    }

    /*
    * 根据id查找
    * */

    @GetMapping("/user{id}")
    public String findById(@PathVariable String id) throws Exception{
        //pathvarible 可以获取到url中的id
        User user = DataUtil.findUserById(id);

        return JSON.toJSONString(user);
    }


    @PostMapping("/users")
    public String create(@RequestBody User user){
        try {
            DataUtil.create(user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }

    @PutMapping("/users/{id}")
    public String updata(@PathVariable String id,@RequestBody User user){
        try {
            DataUtil.updata(id,user);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }


    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable String id){
        try {
            DataUtil.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JSON.toJSONString("fail");
        }

        return JSON.toJSONString("success");
    }
}
