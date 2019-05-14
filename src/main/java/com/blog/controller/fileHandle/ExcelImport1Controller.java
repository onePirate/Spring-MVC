package com.blog.controller.fileHandle;

import com.alibaba.fastjson.JSONArray;
import com.blog.controller.SystemController;
import com.blog.util.DateUtils;
import com.blog.util.ReadExcelUtil;
import com.blog.util.ResultUtil;
import com.blog.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;

/**
 * @function:
 * @Author: gaodawei
 * @Date: 2018/1/17 23:04
 */
@RestController
@RequestMapping("file")
public class ExcelImport1Controller {

    private static Logger log = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping("importExcel1")
    public Result uploadFile(@RequestParam(value = "file") MultipartFile file) {
        long startTime = System.currentTimeMillis();
        log.info("\n*****【时间】:{},【方法】:{}", DateUtils.getLongToString(startTime),"importExcel1->uploadFile");
        //判断文件是否为空
        if (file == null) {
            return ResultUtil.error("请选择文件");
        }
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if (name == null || ("").equals(name) && size == 0) {
            return ResultUtil.error("文件没有数据，上传失败");
        }
        //将excel文件中数据打印出来
        //批量导入。参数：文件名，文件。
        boolean b = batchImport(name,file);
        log.info("\n*****【时间】:{},【响应数据】:{}", DateUtils.getLongToString(startTime),b);
        return ResultUtil.success();
    }

    //批量导入客户，上传的是customerInfo.xls文件
    public boolean batchImport(String name,MultipartFile file){
        boolean b = false;
        //创建处理EXCEL
        ReadExcelUtil readExcel=new ReadExcelUtil();
        //解析excel，获取客户信息集合。
        JSONArray jsonList = readExcel.getExcelInfo(name ,file);
        if(jsonList != null){
            b = true;
        }
        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        for(Object jsonObj:jsonList){
//            customerDoImpl.addCustomers(customer);
            System.out.println(jsonObj);
        }
        return b;
    }
}
