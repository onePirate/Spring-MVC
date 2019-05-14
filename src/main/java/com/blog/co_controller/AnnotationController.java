package com.blog.co_controller;

import com.blog.bean.BindBean;
import com.blog.bean.BindBean2;
import com.blog.exception.UnifyException;
import com.blog.util.JSONUtil;
import com.blog.util.ResultUtil;
import com.blog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: gaodawei
 * @Date: created in 17:47 2017/12/29
 * @function:
 * @version: v1.0.0
 * @ModifyBy:
 * @ModifyBy:
 */
@Controller
@RequestMapping("/anno")
//extends SpecialExceptionHandle
public class AnnotationController  {

    private static Logger log= LoggerFactory.getLogger(AnnotationController.class);

    //用来展示@RequestMapping的使用
    @RequestMapping( value = "/reqMapping" ,method = RequestMethod.POST,
            consumes="application/json",produces="application/json",
            params = "name=gaodawei",headers = "versionCode=1.0.0")
    public Result reqMapping() {
        return ResultUtil.success();
    }

    //直接绑定Bean，不需要注释@ModelAttribute方法
    @ResponseBody
    @RequestMapping(value = "reqBeanParam",method = RequestMethod.POST)
    public Result reqBeanParam(BindBean bindBean) {
        log.info("reqParam请求的参数值：{}", JSONUtil.toJSONString(bindBean));
        return ResultUtil.success(bindBean);
    }

    //注意这时候这个User类一定要有没有参数的构造函数。不然绑定不了参数
    @ResponseBody
    @RequestMapping(value = "reqBean2Param",method = RequestMethod.POST)
    public Result reqBean2Param(BindBean2 bindBean) {
        log.info("reqParam请求的参数值：{}", JSONUtil.toJSONString(bindBean));
        return ResultUtil.success(bindBean);
    }

    //用来展示@RequestBody请求类型为：application/x-www-form-urlencoded下的使用
    @ResponseBody
    @RequestMapping(value = "reqBody1",method = RequestMethod.POST)
    public Result reqBody1(@RequestBody  String name) {
        log.info("reqParam请求的参数值：{}", name);
        return ResultUtil.success(name);
    }

    //用来展示@RequestBody请求类型为：application/json下的使用
    @ResponseBody
    @RequestMapping(value = "reqBody2",method = RequestMethod.POST)
    public Result reqBody2(@RequestBody  BindBean bindBean) {
        log.info("reqParam请求的参数值：{}", JSONUtil.toJSONString(bindBean));
        return ResultUtil.success(bindBean);
    }

    //用来展示@ModelAttribute具体作用
//    @ModelAttribute
//    public void populateModel(@RequestParam String name, Model model) {
//        log.info("\n**********是不是每一个请求都会执行这个，要是有两个怎么办2222222222222？name:"+name);
//        model.addAttribute("attributeName", name);
//    }
//    @ModelAttribute
//    public void populateModel(@RequestParam Integer age, Model model) {
//        log.info("\n**********是不是每一个请求都会执行这个，要是有两个怎么办1111111111111？age:"+age);
//        model.addAttribute("attributeName", age);
//    }
    @RequestMapping(value = "modelAttr1",method = RequestMethod.POST)
    public String modelAttr1() {
        log.info("modelAttr1请求的参数值");
        return "modelAttr";
    }

    //用来展示@ExceptionHandler的作用，当与@ControllerAdvice处理全局异常的共存的表现
    @RequestMapping(value = "ex",method = RequestMethod.POST)
    public Result ex(Integer index,Boolean flag) {
        if(flag==null || !flag){
            throw new UnifyException("请求出错");
        }
        log.info("\n**********ex请求的除数为0异常，参数值：{}", index);
        int val=100/index;
        String[] strArr=new String[5];
        log.info("\n**********ex请求的数组值为："+strArr[index]);
        return ResultUtil.success(index);
    }


}

