package com.blog.co_controller;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/** 
* @function 
* @author  作者 : gaodawei
* @Email   邮箱 : 695390275@qq.com
* @date    创建时间：2017年12月28日 上午4:01:06 
* @version 1.0 
 */
@Controller
@RequestMapping("upload")
public class FileUploadController {
	
	private static Logger log=LoggerFactory.getLogger(FileUploadController.class);
	
	@RequestMapping(value="img",method=RequestMethod.POST)
	public String imgUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			log.info("******process file name is : {}",file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("G:\\Test\\",System.currentTimeMillis()+file.getOriginalFilename()));
		}
		return "success";
	}

}
