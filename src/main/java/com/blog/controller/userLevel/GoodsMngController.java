package com.blog.controller.userLevel;

import com.blog.bean.GoodsBean;
import com.blog.util.JSONUtil;
import com.blog.util.ResultUtil;
import com.blog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/16 21:34
 */
@RestController
@RequestMapping("user/goods")
public class GoodsMngController {

    private static Logger log= LoggerFactory.getLogger(GoodsMngController.class);

    @RequestMapping("list")
    public Result entrance(@RequestBody GoodsBean goodsBean) throws IOException {
        log.info("*****goods--->list参数:{}", JSONUtil.toJSONString(goodsBean));
        return ResultUtil.success();
    }


}
