package com.blog.boot_controller;

import com.blog.util.ResultUtil;
import com.blog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaodawei
 * @Date: created in 1:22 2017/12/30
 * @function:
 * @version: v1.0.0
 * @ModifyBy:
 * @ModifyBy:
 */
@RestController
@RequestMapping("bootAnno")
public class BootAnnoController {

    private static Logger log= LoggerFactory.getLogger(BootAnnoController.class);

    @PostMapping("pMapping")
    public Result pMapping(){
        log.info("***********pMapping");
        return ResultUtil.success();
    }

    @GetMapping("gMapping")
    public Result gMapping(){
        log.info("***********gMapping");
        return ResultUtil.success();
    }
}
