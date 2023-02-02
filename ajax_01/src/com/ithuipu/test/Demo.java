package com.ithuipu.test;

/**
 * @className: Demo
 * @author: Mr.BingYu
 * @description:
 * @date: 2023/02/01 19:09
 **/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithuipu.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 测试--json与对象的相互转换
 */
public class Demo {

    private ObjectMapper objectMapper = new ObjectMapper();

    //普通的对象--json
    @Test
    public void demo1() throws Exception {
        //1.user--json
        User user = new User("李四", 23);
        String json = objectMapper.writeValueAsString(user);
        System.out.println("json:" + json);
        //2.json--user
        User user1 = objectMapper.readValue(json, User.class);
        System.out.println(user1);

    }

    //map----json---map
    @Test
    public void demo2() throws Exception {
        //1.创建map
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "李四");
        map.put("hobby", "java");
        //2.
        String json = objectMapper.writeValueAsString(map);
        System.out.println(json);
        //3.json--map
        HashMap<String, String> hashMap = objectMapper.readValue(json, HashMap.class);
        System.out.println(hashMap);
    }

    //map---user---json
    @Test
    public void demo3() throws Exception {
        //1.创建map
        HashMap<String, User> hashMap = new HashMap<>();
        hashMap.put("java1班", new User("李四", 23));
        hashMap.put("java2班", new User("王五", 26));
        hashMap.put("java3班", new User("王五", 21));
        //2.map---json
        String json = objectMapper.writeValueAsString(hashMap);
        System.out.println(json);
        //3.json---map
        HashMap<String, User> map2 = objectMapper.readValue(json, new TypeReference<HashMap<String, User>>() {
        });
        System.out.println(map2);
    }

    //list---json
    @Test
    public void demo4() throws Exception {
        //1.创建集合
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("java");
        arrayList.add("c++");
        arrayList.add("ajax");
        //list---json
        String json = objectMapper.writeValueAsString(arrayList);
        System.out.println(json);
        //json--list
        ArrayList<String> arrayList2 = objectMapper.readValue(json, ArrayList.class);
        System.out.println(arrayList2);
    }

    //list<自定义对象>---json---list<自定义对象>
    @Test
    public void demo5() throws Exception {
        //1.准备数据
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User("哈哈", 12));
        arrayList.add(new User("呵呵", 32));
        arrayList.add(new User("嘿嘿", 22));
        //2.List<User>----json
        String json = objectMapper.writeValueAsString(arrayList);
        System.out.println(json);
        //3.json---List<User>
        ArrayList<User> arrayLis2 = objectMapper.readValue(json, new TypeReference<ArrayList<User>>() {
        });
        System.out.println(arrayLis2);
    }

}
