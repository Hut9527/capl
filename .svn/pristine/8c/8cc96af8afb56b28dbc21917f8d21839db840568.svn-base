package com.sunjays.capl.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoiServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 //获得请求文件名  
        String filename = request.getParameter("filename");
        String s1 = request.getParameter("mapX");
        String s2 = request.getParameter("mapY");
        String s4 = request.getParameter("mapG");
        String s3 = request.getParameter("mapK");
        int mapX=Integer.parseInt(s1);
        int mapY = Integer.parseInt(s2);
        int mapK = Integer.parseInt(s3);
        int mapG = Integer.parseInt(s4);
        
        System.out.println(filename+"..."+mapX+"..."+mapY+"..."+mapG+"..."+mapK);  
        
        //-----------------------------------------------  保存  -------------------------------------------------------------------------
        //获取目标文件的绝对路径  
        String fileName = getServletContext().getRealPath("/image/");  
        
        BufferedImage image = null;
		try {
			image = (new Robot()).createScreenCapture(new
				 Rectangle(mapX, mapY, mapK, mapG));
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
        
       
     //-----------------------------------------------  下载  -------------------------------------------------------------------------
        //设置文件MIME类型  
        response.setContentType(getServletContext().getMimeType(filename));  
        //设置Content-Disposition  
        response.setHeader("Content-Disposition", "attachment;filename="+filename);  
        //读取目标文件，通过response将目标文件写到客户端  
        //获取目标文件的绝对路径  
        String fullFileName = getServletContext().getRealPath("/image/" + filename);  
        
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
