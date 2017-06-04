package cn.com.action;

import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uploadFile(request,response);
		request.getRequestDispatcher("../jsp/nowWriteCount.jsp").forward(request, response);;
		
	}
	
	//上传文件
	public void  uploadFile(HttpServletRequest request, HttpServletResponse response){
		
		List<FileItem> list = null;
		String saveFileName = null;
		String otherPath = null;
		String rootPath = this.getServletContext().getRealPath("/WEB-INF/upload/");
		
		try {
			DiskFileItemFactory factoy = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factoy);
			upload.setFileSizeMax(1024*1024*5);
			upload.setSizeMax(1024*1024*20);
            upload.setHeaderEncoding("utf-8");
			list = upload.parseRequest(request);
			
			if(list != null){
				for(FileItem item : list){
				  	if(item.isFormField()){
				  		String name = item.getFieldName();
				  		String value = item.getString("utf-8");
				  		System.out.println(name + "=" + value );			  		
				  	}
				  	else{
				  		String fileName  = item.getName();
				  		saveFileName = makeFileName(fileName);
				  		otherPath = makeSaveFilePath(saveFileName,rootPath);
				  		InputStream in = item.getInputStream();
				  		OutputStream out = new FileOutputStream(rootPath + otherPath + "\\" + saveFileName);
				  		int b = -1;
				  		while((b = in.read()) != -1){
				  			out.write(b);
				  		}
				  		out.flush();
				  		in.close();
				  		out.close();
				  	}
				  	
				}
			}
			
			
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//设置唯一文件名
	public String makeFileName(String fileName){
		
		//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		return	UUID.randomUUID().toString() + "_" + fileName;

	}
	//构建相当路径，如..\2\10
	public String makeSaveFilePath(String Filename,String rootPath){
		//得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
		 int hashcode = Filename.hashCode();
		 int dir1 = hashcode&0xf;//0--15
		 int dir2 = (hashcode&0xf0)>>4;//0--15
		 //构造新的保存目录
		 String dir = rootPath + "\\" + dir1 + "\\" + dir2; //upload\2\3 upload\3\5
	     //File既可以代表文件也可以代表目录    
		 File file = new File(dir);
		 //如果目录不存在
		 if(!file.exists()){
			 file.mkdirs();
		 }
		 
//		 return dir;
		 return "\\" + dir1 + "\\" + dir2 ;
	}
	
	//增加保存路径
//	public void addRecordPath(String rootPath,String other,String fileName,saveFileName,){
//		
//	}


	
}
