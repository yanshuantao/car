package com.yst.controller.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yst.common.util.IDUtils;
import com.yst.common.util.JsonUtils;
import com.yst.manager.util.FtpManager;

/**
 * 图片上传controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class PictureController {
	
	@Value("${ftp.img.url}")
	private String url;
	@Value("${ftp.img.port}")
	private int port;
	@Value("${ftp.img.username}")
	private String username;
	@Value("${ftp.img.password}")
	private String password;
	@Value("${ftp.img.serverPath}")
	private String serverPath;
	@Value("${ftp.img.itemImgPath}")
	private String itemImgPath;
	@Value("${ftp.img.httpPath}")
	private String httpPath;
	
	

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile) {
		try {
			//接收上传的文件
			//取扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			String newFileName = IDUtils.createID()+"."+extName;
			
			//ftp上传
			String resultUrl = FtpManager.uploadFile(url, port, username, password, serverPath,itemImgPath,httpPath, newFileName, uploadFile.getInputStream());
			
			//响应上传图片的url
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", resultUrl);
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.objectToJson(result);
		}
		
	}
}
