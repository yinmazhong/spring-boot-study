package com.example.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*
* 控制器类
* */


@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello(){
        Map<String,Object> map =  new HashMap<>();
        map.put("hello","world");
        return map;
    }

}
