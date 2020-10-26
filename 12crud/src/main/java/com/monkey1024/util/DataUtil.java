package com.monkey1024.util;

import com.monkey1024.bean.User;


import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataUtil {
    private static HashMap<String, User> dataMap= new HashMap<>();
    //模拟初始化数据
    static {
        User user1 = new User("jack", "18827331935", "武汉", LocalDate.of(1998, 12, 25));
        User user2 = new User("lucy", "17340526875", "武汉", LocalDate.of(1999, 07, 28));
        User user3 = new User("nobody", "18879625786", "梦中", LocalDate.of(1998, 02, 12));
        dataMap.put("1",user1);
        dataMap.put("2",user2);
        dataMap.put("3",user3);
    }

    //查询所有的数据
    public static HashMap<String, User> findAll() {
        return dataMap;
    }

    //根据ID查询
    public static User findUserById(String id){
        return dataMap.get(id);
    }


    //添加操作
    public static void create(User user) throws  Exception{
        //遍历map找到key的最大值
        Iterator<Map.Entry<String, User>> iterator = dataMap.entrySet().iterator();

        int max = 3;

        while(iterator.hasNext()){
            Map.Entry<String, User> next = iterator.next();
            //将string类型转换成int类型就用Integer.parseInt(String);
            int i = Integer.parseInt(next.getKey());
            if (max<i){
                max = i;
            }
        }

        //将最大值做自增运算，然后作为key放到map中
        dataMap.put(++max +"",user);
    }

    //修改
    public static void updata(String id,User user)throws Exception{
        dataMap.put(id, user);
    }

    public static void delete(String id)throws Exception {
        dataMap.remove(id);//因为是一个钥匙对应一个value，所以删除id就可以了
    }
}
