package com.yst.manager.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * 
 *@company：当代金融
 *@package com.app.base.utils
 *@title 文件名：FtpManager.java
 *@author (作者): [cuizhongguo] 
 *@date 日期：2016年6月22日下午4:46:55
 *@version (版本信息)： Copyright 2016 版权所有
 */
public class FtpManager {
	
	private static FtpManager instance;
	
	public synchronized static FtpManager getInstance(){
		if( instance == null ){
			instance = new FtpManager(); 
		}
		return instance;
	}  
	
	public static String uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) {
        String result="";
		FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);//连接FTP服务器
            //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);         
              
            input.close();
            ftp.logout();
            result="http://"+url+path+filename;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }
	
	
	/**
	 * 登录
	 * @param s_url
	 * @param uname
	 * @param pass
	 */
	public static FTPClient login(String s_url,String uname,String pass){
		FTPClient ftpClient = new FTPClient();
		try{
			//连接
			ftpClient.connect(s_url);
			ftpClient.login(uname,pass);
			//检测连接是否成功
			int reply = ftpClient.getReplyCode();
			if(!FTPReply.isPositiveCompletion(reply)) {
				closeCon(ftpClient);
				System.err.println("FTP server refused connection.");
//				System.exit(1);
			}
		}catch(Exception ex){
			ex.printStackTrace(); 
			closeCon(ftpClient);
			throw new RuntimeException("FTP客户端出错！", ex); 
		}
		return ftpClient;
	}
	/** 
     * FTP上传单个文件测试 
     *//* 
    public String upload(File srcFile,String path,String fileName,String server,String username,String password) { 
        FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(srcFile); 
            if (path.contains("/")) {
            	if(!CreateDirecroty(path + fileName,ftpClient)) {
                	return null;
                }
            }
            //设置上传目录 
            ftpClient.changeWorkingDirectory(serverPath + path); 
            ftpClient.setBufferSize(1024); 
            ftpClient.setControlEncoding("GBK"); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.storeFile(fileName, fis); 
            String domain= PropertiesUtil.getPropertiesVal("/file.properties", "ftp.domain");//ftp根目录
            String httppath= PropertiesUtil.getPropertiesVal("/file.properties", "ftp.httppath");//ftp根目录
            return domain+httppath+path+fileName;
        } catch (IOException e) { 
        	System.out.println(e.getMessage());
            return null;
        } finally { 
        	this.closeCon(ftpClient);
        	IOUtils.closeQuietly(fis); 
        } 
    } */
    
    /** 
     * FTP下载单个文件测试 
     *//* 
    public boolean download(String filePath,String downPath) { 
    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
    	FileOutputStream fos = null; 
        try { 
            String remoteFileName = serverPath + filePath; 
            fos = new FileOutputStream(downPath); 

            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.retrieveFile(remoteFileName, fos); 
        } catch (IOException e) { 
            System.out.println(e.getMessage());
            return false;
        } finally { 
        	this.closeCon(ftpClient);
        	IOUtils.closeQuietly(fos); 
        }
        return true;
    }*/
    
    /*public InputStream downloadFile(String filePath ,InputStream inputStream) { 
    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
    	try { 
            String remoteFileName = serverPath + filePath; 

            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            inputStream = ftpClient.retrieveFileStream(remoteFileName);
        } catch (IOException e) { 
            System.out.println(e.getMessage());
        } finally { 
        	this.closeCon(ftpClient);
        }
        return inputStream;
    }*/
   /* *//**
     * 删除服务器文件
     * @param srcFname
     * @return
     *//*
    public boolean removeFile(String srcFname){  

    	FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);

    	boolean flag = false;
		try {
			flag = ftpClient.deleteFile(srcFname);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.closeCon(ftpClient);
		}
    	return flag;
    }
    
    *//**
    * 递归创建远程服务器目录
    * @param remote  远程服务器文件绝对路径
    * @return 目录创建是否成功
    * @throws IOException
    *//*
    public boolean CreateDirecroty(String remote,FTPClient ftpClient) throws IOException {
        boolean success = true;
        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(new String(directory))) {
        	int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end));
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    if (ftpClient.makeDirectory(subDirectory)) {
                    	ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录失败");
                        success = false;
                        return success;
                    }
                }
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }
    
    *//**
     * 销毁ftp连接 
     */
    public static void closeCon(FTPClient ftpClient){
    	if(ftpClient !=null){
    		if(ftpClient.isConnected()){
    			try {
					ftpClient.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//    			try {
//    				//ftpClient.logout();
//    				//ftpClient.disconnect();
//    			} catch (IOException e) {
//    				e.printStackTrace();
//    			}
    		}
    	}
    }
    public static void main(String[] args) {
		FtpManager.login("192.168.2.108", "dpt_ftp", "dpt_P@ss2w0rd");
	}

    
    /*
    public static void main(String[] args) { 
    	File srcFile = new File("E://video02.avi"); 
    	System.out.println(FtpManager.getInstance().upload(srcFile, "/test/", "234.avi"));
    	//System.out.println(FtpManager.getInstance().removeFile("/test/234.avi"));
    } 
    
    
    *//**
     * <li>功能描述：下载本地文件
     * @param filePath 服务器文件地址
     * @param fileName 文件名称
     * @param request
     * @param response
     * void 
     * @author qiaomengzhao
     *//*
    public void downloadFile(String filePath,String fileName,HttpServletRequest request, HttpServletResponse response) {
    	BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
    	try {
            FTPClient ftpClient = FtpManager.getInstance().login(server, username, password);
            ftpClient.setBufferSize(1024); 
                //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            InputStream fis =ftpClient.retrieveFileStream(filePath);
			//response.setContentType(contentType(filePath));
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int index=fileName.lastIndexOf(".");
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {  
				fileName = URLEncoder.encode(fileName, "UTF-8");
			}else if(request.getHeader("User-Agent").toUpperCase().indexOf("FIREFOX") > 0){
				fileName = new String(fileName.trim().replace(" ","").replaceAll("　", "").getBytes("UTF-8"), "ISO8859-1");
			}else{  
				fileName = URLEncoder.encode(fileName, "UTF-8");
			}
            if(index==-1){
            	String fileSuffix = filePath.substring(filePath.lastIndexOf("."));
            	fileName=fileName+fileSuffix;
            }
			response.setHeader("Content-Disposition", "attachment; " + "filename=" + fileName);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[1024];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally{
        	try {
	        	if(bis!=null){
					bis.close();
				}
				if(bos!=null){
					bos.close();
				}
        	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    *//**
     * <li>功能描述：下载网络资源
     * @param filePath
     * @param fileName
     * @param request
     * @param response
     * void 
     * @author qiaomengzhao
     *//*
    public void downloadFileByHttp(String filePath,String fileName,HttpServletRequest request, HttpServletResponse response){
    	BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		URL url = null;
		try {
			url = new URL(filePath);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
    		request.setCharacterEncoding("UTF-8");
    		int index=fileName.lastIndexOf(".");
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {  
				fileName = URLEncoder.encode(fileName, "UTF-8");
			}else if(request.getHeader("User-Agent").toUpperCase().indexOf("FIREFOX") > 0){
				fileName = new String(fileName.trim().replace(" ","").replaceAll("　", "").getBytes("UTF-8"), "ISO8859-1");
			}else{  
				fileName = URLEncoder.encode(fileName, "UTF-8");
			}
            if(index==-1){
            	String fileSuffix = filePath.substring(filePath.lastIndexOf("."));
            	fileName=fileName+fileSuffix;
            }
			response.setHeader("Content-Disposition", "attachment; " + "filename="+ fileName);

			bis = new BufferedInputStream(inStream);
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[1024];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(bis!=null){
					bis.close();
				}
				if(bos!=null){
					bos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
}

