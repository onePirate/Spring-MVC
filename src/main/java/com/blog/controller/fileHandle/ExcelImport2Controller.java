//package com.blog.controller.fileHandle;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.blog.controller.SystemController;
//import com.blog.enums.GoodsInfoEnum;
//import com.blog.util.ResultUtil;
//import com.blog.vo.Result;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStream;
//
////import jxl.Sheet;
////import jxl.Workbook;
////import jxl.read.biff.BiffException;
//
///**
// * @function:
// * @Author: gaodawei
// * @Date: 2018/1/17 23:04
// */
//@RestController
//@RequestMapping("file")
//public class ExcelImport2Controller {
//
//    private static Logger log = LoggerFactory.getLogger(SystemController.class);
//
//    /**
//     * 读取Excel文件，并将数据打印出来
//     * 缺点：不支出读取 excel 2007 文件(*.xlsx)。只支持 excel 2003 (*.xls)
//     * 如果读取(*.xlsx)格式文件，会报：Unable to recognize OLE stream 错误
//     *
//     * @param file
//     * @param style
//     * @return
//     */
//    @RequestMapping(value = "importExcel2")
//    public Result importUser(String style, MultipartFile file) {
//        JSONArray jsonList = new JSONArray();
//        try {
//            //也可以用request获取上传文件
//            //MultipartFile  fileFile = request.getFile("file"); //这里是页面的name属性
//            //转换成输入流
//            InputStream is = file.getInputStream();
//            //得到excel
//            Workbook workbook = Workbook.getWorkbook(is);
//            //得到sheet
//            Sheet sheet = workbook.getSheet(0);
//            //得到列数
//            int colsNum = sheet.getColumns();
//            //得到行数
//            int rowsNum = sheet.getRows();
//            //单元格
//            Cell cell;
//            if ("obj".equals(style)){
//                savaDataByObj(jsonList, sheet, colsNum, rowsNum);
//            }else if("arr".equals(style)){
//                saveDataByArr(jsonList, sheet, colsNum, rowsNum);
//            }
//            log.info("list中的数据为：" + jsonList);
//            //做你需要的操作
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (BiffException e) {
//            e.printStackTrace();
//        }
//        return ResultUtil.success(jsonList);
//    }
//
//    /**
//     * 将Excel里面的数据通过对象的方式保存
//     *
//     * @param jsonList
//     * @param sheet
//     * @param colsNum
//     * @param rowsNum
//     */
//    private void savaDataByObj(JSONArray jsonList, Sheet sheet, int colsNum, int rowsNum) {
//        Cell cell;
//        for (int i = 1; i < rowsNum; i++) {//我的excel第一行是标题,所以 i从1开始
//            JSONObject colsJson = new JSONObject();
//            for (int j = 0; j < colsNum; j++) {
//                cell = sheet.getCell(j, i);//注意:第一个参数是列.第二个参数是行
//                for (GoodsInfoEnum ge : GoodsInfoEnum.values()) {
//                    if (j == ge.getIndex()) {
//                        colsJson.put(ge.getProperty(), cell.getContents());
//                    }
//                }
//            }
//            jsonList.add(colsJson);
//        }
//    }
//
//    /**
//     * 将Excel里面的数据通过数据的方式保存
//     *
//     * @param jsonList
//     * @param sheet
//     * @param colsNum
//     * @param rowsNum
//     */
//    private void saveDataByArr(JSONArray jsonList, Sheet sheet, int colsNum, int rowsNum) {
//        Cell cell;
//        for (int i = 1; i < rowsNum; i++) {//我的excel第一行是标题,所以 i从1开始
//            JSONArray colsArr = new JSONArray();
//            for (int j = 0; j < colsNum; j++) {
//                cell = sheet.getCell(j, i);//注意:第一个参数是列.第二个参数是行
//                colsArr.add(cell.getContents());
//            }
//            jsonList.add(colsArr);
//        }
//    }
//}
