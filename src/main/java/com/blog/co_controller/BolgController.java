package com.blog.co_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: gaodawei
 * @Date: created in 0:57 2017/12/31
 * @function:
 * @version: v1.0.0
 * @ModifyBy:
 * @ModifyBy:
 */
@Controller
@RequestMapping("blog")
public class BolgController {

    @RequestMapping("normalOper")
    public ModelAndView normalOper(HttpServletRequest req, HttpServletResponse rep) {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello");
        return mv;
    }
}
