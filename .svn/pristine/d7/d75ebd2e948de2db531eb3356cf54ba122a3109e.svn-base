package com.sunjays.capl.web.common;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;




/**
 * 公共类
 */
public class BaseController {
	//上传用参数
	protected Map<String,Object> uploadFileMap = new HashMap<String,Object>();
	// ================= 导出用的参数====================
	protected WritableWorkbook wwb = null;
	protected String filename="";
	// ================= 分页用的参数====================

	protected int pageNum = 1; // 当前页
	protected int startIndex = 0; // 开始索引
	protected int pageSize = 1; // 每页显示多少条记录
	protected Integer active = 0;
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if (pageNum > 1) {
			startIndex = ((pageNum - 1) * pageSize);
		}else {
			startIndex = 0;
		}
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 接受前台传入的分页参数进行设置
	 * @param request
	 */
	protected void pageParameter(HttpServletRequest request) {
	
		//获取page和pagesize的值
		String pageStr =  request.getParameter("pageNum");
		//String pagesizeStr =  request.getParameter("pageSize");
		String pagesizeStr =  (String)request.getSession().getAttribute("pageSize");
		//System.out.println(pagesizeStr+"++++++++++++++++++++++");
		if (pageStr != null && !"".equals(pageStr))	setPageNum(Integer.parseInt(pageStr));
		else pageNum = 1; setPageNum(pageNum);
		if (pagesizeStr != null && !"".equals(pagesizeStr)) setPageSize(Integer.parseInt(pagesizeStr));
		else pageSize = 10; setPageSize(pageSize);
	}
	/**
	 * 导出到excel
	 * @throws IOException 
	 */
	protected WritableSheet toExcelBase1(HttpServletRequest request) throws IOException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		// 创建可写入的Excel工作簿
		// String savePath = Utils.getProperties("xls_export_path");
		String savePath = request.getSession().getServletContext().getRealPath("upload");
		filename = sdf.format(date) + ".xls";
		String fileName = savePath + "\\" + filename;
		File file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		// 以fileName为文件名来创建一个Workbook
		wwb = Workbook.createWorkbook(file);

		// 创建工作表
		WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
		return ws;
	}
	protected void toExcelClose() throws WriteException, IOException{
		// 写进文档
		wwb.write();
		// 关闭Excel工作簿对象
		wwb.close();
	}
	/**
	 * 下载
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/down")  
    public void down(HttpServletRequest request,HttpServletResponse response,String filename){  
		BufferedOutputStream out=null;
		InputStream bis=null;
		//模拟文件，myfile.txt为需要下载的文件  
        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/"+filename;  
        //获取输入流  
        try {
			bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
			//假如以中文名下载的话  
			//String filename = "下载文件.txt";  
			//转码，免得文件名中文乱码  
			//filename = URLEncoder.encode(filename,"UTF-8");  
			//设置文件下载头  
			response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
			//1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
			response.setContentType("multipart/form-data"); 
			out = new BufferedOutputStream(response.getOutputStream());  
			int len = 0;  
			while((len = bis.read()) != -1){  
			    out.write(len);  
			    //out.flush();  
			} 
			out.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				if (bis!=null) bis.close();
				 if (out!=null) out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }   
	
	/**
	 * 异步上传文件
	 * @param request
	 * @return
	 */
	@RequestMapping("uoloadFile.do")
	@ResponseBody
	public String uoloadFile(HttpServletRequest request){
		String name=request.getParameter("name");
		String result ="";
		try {
			result=uploadFile(request,name);
		} catch (FileUploadException e) {
			result="";
		}
		if(result.equals("0")){
			return uploadFileMap.get(name)+"";
		}else if(result.equals("-4")){
			return "0";
		}else{
			return "1";
		}
	} 
	
	/**
	 * 上传单个文件-- 需要form表单的name 
	 * 0success -1请选择文件 -2上传目录不存在 -3上传目录没有写权限-4上传文件大小超过限制-5上传文件扩展名是不允许的扩展名 -6上传失败
	 * @throws FileUploadException 
	 */
	protected String uploadFile(HttpServletRequest request,String name) throws FileUploadException{
		// 文件保存目录路径
		String savePath = request.getSession().getServletContext().getRealPath("upload");
		// 定义允许上传的文件扩展名
		String fileExtStr = "xls,xlsx";
		// 最大文件大小
		long maxSize = Long.parseLong("6291456");
		// 创建文件夹
		File saveDirFile = new File(savePath);
		if (!saveDirFile.exists()) {
			saveDirFile.mkdirs();
		}
		// 检查文件
		if (!ServletFileUpload.isMultipartContent(request)) {
			return "-1";
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			return "-2";
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			return "-3";
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(savePath)); 
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> itr = items.iterator();
		Map<String,Object> map = new HashMap<String,Object>();
		while (itr.hasNext()) {
			FileItem item = (FileItem) itr.next();
			if (!item.isFormField()) {
				String formName = item.getFieldName();
				//文件的名字与from表单不一致 不上传
				if(!formName.equals(name)){
					item.delete();//删除临时文件 继续循环
					continue;
				}
				// 检查文件大小
				if (item.getSize() > maxSize) {
					return "-4";
				}
				// 检查扩展名
				String fileName = item.getName();
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				if (fileExtStr.indexOf(fileExt) < 0) {
					return "-5";
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				String newFileName = sdf.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				try {
					File uploadedFile = new File(savePath, newFileName);
					item.write(uploadedFile);
				} catch (Exception e) {
					return "-6";
				}
				map.put(formName, newFileName);
			}
		}
		uploadFileMap=map;
		return "0";
	}
}
