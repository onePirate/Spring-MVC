package com.blog.co_controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: gaodawei
 * @Date: created in 1:22 2017/12/30
 * @function:
 * @version: v1.0.0
 * @ModifyBy:
 * @ModifyBy:
 */
@Controller
@RequestMapping("to")
public class PageSkipController {

    private static Logger log= LoggerFactory.getLogger(PageSkipController.class);

    @RequestMapping(value = "toAjaxDemo",method = RequestMethod.POST)
    public String toAjaxDemo(){
        log.info("***********跳转到AjaxDemo.vm页面");
        return "ajaxDemo";
    }
}
