package com.sunjays.capl.web.controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunjays.capl.utils.PrintImageUtils;

@Controller
@RequestMapping("img")
public class ImgController {
	
	private String filename;

	@RequestMapping("/save.do")
	public void save(HttpServletRequest request,HttpServletResponse response) throws Exception{
       //保存方法
		saveImg(request,response);
		
		down(request,response,filename);
		
	}
	
	//百度静态地图保存
	@RequestMapping("/saveStatic.do")
	public void saveStatic(HttpServletRequest request,HttpServletResponse response,
			String center,String zoom,String filename,String allpolins) throws Throwable {
		//通过百度静态地图方法制作url
		String urlString = "http://api.map.baidu.com/staticimage?ak=Xdttjo4Cj46nWu8cj9e8KqMYA7XzFmz4&"
        		+ "center="+center+"&zoom=" + zoom + "&width=1024&height=1024"
				+ "&paths="+allpolins
				+ "&pathStyles=black,5,1";
		
		//保存进服务器
		saveStaticimg(request,urlString,filename);
		
        //下载
		down(request,response,filename);
	}
	
	
	@RequestMapping("/printA.do")
	public String prinA(HttpServletRequest request,HttpServletResponse response,
			String center,String zoom,String filename,String allpolins) throws Exception {
		//通过百度静态地图方法制作url
		String urlString = "http://api.map.baidu.com/staticimage?ak=Xdttjo4Cj46nWu8cj9e8KqMYA7XzFmz4&"
        		+ "center="+center+"&zoom=" + zoom + "&width=1024&height=1024"
				+ "&paths="+allpolins
				+ "&pathStyles=black,5,1";

		//保存进服务器
		saveStaticimg(request,urlString,filename);
		//获取目标文件的绝对路径  
        String fileName = request.getServletContext().getRealPath("/image/" + filename); 
        //调用打印方法
        PrintImageUtils.drawImage(fileName);
        
        return "carspeed";
	}
	
	@RequestMapping("/printB.do")
	public String prinB(HttpServletRequest request,HttpServletResponse response,
			String center,String zoom,String filename,String allpolins) throws Exception {
		//通过百度静态地图方法制作url
		String urlString = "http://api.map.baidu.com/staticimage?ak=Xdttjo4Cj46nWu8cj9e8KqMYA7XzFmz4&"
        		+ "center="+center+"&zoom=" + zoom + "&width=1024&height=1024"
				+ "&paths="+allpolins
				+ "&pathStyles=black,5,1";

		//保存进服务器
		saveStaticimg(request,urlString,filename);
		//获取目标文件的绝对路径  
        String fileName = request.getServletContext().getRealPath("/image/" + filename); 
        //调用打印方法
        PrintImageUtils.drawImage(fileName);
        
        return "peoplespeed";
	}
	
	//把图片保存到本地
	public void saveImg(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//获得请求文件名  
        filename = request.getParameter("filename");
        String s1 = request.getParameter("mapX");
        String s2 = request.getParameter("mapY");
        String s4 = request.getParameter("mapG");
        String s3 = request.getParameter("mapK");
        String su1 = s1.substring(0,3);
        String su4 = s4.substring(0, 3);
        int mapX=Integer.parseInt(su1);
        int mapY = Integer.parseInt(s2);
        int mapK = Integer.parseInt(s3);
        int mapG = Integer.parseInt(su4);
        
        System.out.println(filename+"..."+mapX+"..."+mapY+"..."+mapG+"..."+mapK);  
        
        //-----------------------------------------------  保存  -------------------------------------------------------------------------
        //获取目标文件的绝对路径  
        String fileName = request.getServletContext().getRealPath("/image/");  
        
        BufferedImage image = null;
		try {
			image = (new Robot()).createScreenCapture(new
				 Rectangle(mapY, mapX, mapK, mapG));
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       // 截图保存的路径 
       File screenFile = new File(fileName);    
       // 如果路径不存在,则创建  
       if (!screenFile.getParentFile().exists()) {  
           screenFile.getParentFile().mkdirs();  
       } 
       //判断文件是否存在，不存在就创建文件
       if(!screenFile.exists()&& !screenFile .isDirectory()) {
           screenFile.mkdir();
       }
       
       File f = new File(screenFile, filename);        
       ImageIO.write(image, "png", f);
	}
	
	//绝对路径
	@RequestMapping("/getFactUrl.do")
	@ResponseBody
	public String[] getFactUrl(HttpServletRequest request){
		//获取绝对路径
		String fullFileName = request.getServletContext().getRealPath("/image/logA.png");
		String[] split = fullFileName.split("\\\\");
		
		return split;
	}
	
	//百度静态地图保存的方法
	public  void saveStaticimg(HttpServletRequest request,
			String urlString, String filename) throws Exception {  
        // 构造URL  
        URL url = new URL(urlString);  
        // 打开连接  
        URLConnection con = url.openConnection();  
        //设置请求超时为5s  
        con.setConnectTimeout(5*1000);  
        // 输入流  
        InputStream is = con.getInputStream();  
        // 1K的数据缓冲  
        byte[] bs = new byte[1024];  
        // 读取到的数据长度  
        int len;  
        // 输出的文件流  
        String fileName = request.getServletContext().getRealPath("/image/");
        // 截图保存的路径 
        File savePath = new File(fileName);    
        // 如果路径不存在,则创建  
        if (!savePath.getParentFile().exists()) {  
        	savePath.getParentFile().mkdirs();  
        } 
        //判断文件是否存在，不存在就创建文件
        if(!savePath.exists()&& !savePath .isDirectory()) {
        	savePath.mkdir();
        }
        
        OutputStream os = new FileOutputStream(savePath.getPath()+"\\"+filename);  
        // 开始读取  
        while ((len = is.read(bs)) != -1) {  
          os.write(bs, 0, len);  
        }  
        // 完毕，关闭所有链接  
        os.close();  
        is.close();  
    }  
	
	//下载的方法
	public void down(HttpServletRequest request,HttpServletResponse response
			,String filename) throws Exception {
		//设置文件MIME类型  
        response.setContentType(request.getServletContext().getMimeType(filename));  
        //设置Content-Disposition  
        response.setHeader("Content-Disposition", "attachment;filename="+filename);  
        //读取目标文件，通过response将目标文件写到客户端  
        //获取目标文件的绝对路径  
        String fullFileName = request.getServletContext().getRealPath("/image/" + filename);  
        System.err.println("绝对路径:"+fullFileName);
        //读取文件  
        InputStream in = new FileInputStream(fullFileName); 
        OutputStream out = response.getOutputStream();  
          
        //写文件  
        int b;  
        while((b=in.read())!= -1)  
        {  
            out.write(b);  
        }  
          
        in.close();  
        out.close();  
	}
	
}
