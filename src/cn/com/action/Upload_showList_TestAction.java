package cn.com.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * @author 龚飞
 * 测试上传文件和显示需要下载文件的列表
 */
public class Upload_showList_TestAction extends HttpServlet {

@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        
	        String upLoad = "";
	        upLoad = request.getParameter("upLoad");
	        if((null == upLoad)||("".equals(upLoad))){
	        	 //显示文件下载列表
	              showFileListLoad(request,response);
	              
	        }
	        else if(upLoad.equals("fileUpLoad")){
	        	// 文件上传
		        testUpload(request,response);
		        //转到下载列表
		        showFileListLoad(request,response);
		        
	        }

}



// * 简单的文件上传
 /*
 public void testUpload(HttpServletRequest request, HttpServletResponse response){

String mesage = null;
	//获取路径
	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	
	System.out.println(this.getServletContext());
	System.out.println(savePath);
	//使用Apache文件上传组件处理文件上传步骤：
     //1、创建一个DiskFileItemFactory工厂
   DiskFileItemFactory factory = new DiskFileItemFactory(); 
    //2、创建一个文件上传解析器
    ServletFileUpload upload = new ServletFileUpload(factory); 
    upload.setHeaderEncoding("utf-8");
   // 3、判断提交上来的数据是否是表单
    if(!ServletFileUpload.isMultipartContent(request)){
       //否则按传统方式获取
    	return;
    }
   
  //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合
    try {
		List<FileItem> list = upload.parseRequest(request);
		for(FileItem item : list){
			String filename = null;
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString("utf-8");
				System.out.println(name+"="+value);

			}
			else{
				filename = item.getName(); 
				System.out.println(filename);
				if((null == filename)||(filename.trim() == "")){
					 continue;	
				}
				  

			filename = filename.substring(filename.lastIndexOf("\\")+1);
			try {
			  InputStream in = item.getInputStream();
			  OutputStream out = new FileOutputStream(new File(savePath + "\\" + filename));
			  int ch = 0;
			  while((ch = in.read()) != -1){
                   out.write(ch);
			  }
			  out.flush();
			  in.close();
			  out.close();
			  item.delete();
			  mesage = "文件上传成功";
			} catch (IOException e) {
			     mesage = "文件上传失败";
				e.printStackTrace();
			}
			
			request.setAttribute("message",mesage);
	
			}
			
		}
	} catch (FileUploadException | UnsupportedEncodingException e) {
		e.printStackTrace();
	}

}
*/


 
// 优化后的文件上传 
public void testUpload(HttpServletRequest request, HttpServletResponse response){
	
	//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	 //上传时生成的临时文件保存目录
	String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
	File tempFile = new File(tempPath);
	if(!tempFile.exists()){
		tempFile.mkdirs();
	}
	//消息提示
	String message = "";
	
	//使用Apache文件上传组件处理文件上传步骤：
    //1、创建一个DiskFileItemFactory工厂
	DiskFileItemFactory factory = new DiskFileItemFactory();
	//设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中。
	factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
	//设置上传时生成的临时文件的保存目录
	factory.setRepository(tempFile);
	//2、创建一个文件上传解析器
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setProgressListener(new ProgressListener(){

		@Override
		public void update(long pByteRead, long pContentLongth, int arg2) {
			System.out.println("文件大小： " + pByteRead + ",当前已处理：" + pByteRead);	
		}
	});
	upload.setHeaderEncoding("utf-8");
	upload.setFileSizeMax(1024*100);
	upload.setSizeMax(1024*1024);
	
	//3、判断提交上来的数据是否是上传表单的数据,multipart/form-data
	if(!ServletFileUpload.isMultipartContent(request)){
		return;
	}
	try {
	//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> list = upload.parseRequest(request);
		for (FileItem item : list) {
			if(item.isFormField()){
				try {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name+ " =" + value);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
			else if((item.getName() != null)&&(item.getName().trim() != "")){
				try {
					
					String fileName = item.getName().trim();
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					InputStream in = item.getInputStream();
					
					String saveFileName = makeFileName(fileName);
					
					String realFilePath = makeSaveFilePath(saveFileName,savePath);
					
					OutputStream out = new FileOutputStream(realFilePath + "\\" + saveFileName);
					int b = -1;
					while((b = in.read()) != -1){
						out.write(b);
					}
					out.flush();
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	} catch (FileUploadBase.FileSizeLimitExceededException e){
		e.printStackTrace();
		System.out.println("单个文件超出最大值");
	}
	 catch (FileUploadBase.SizeLimitExceededException e){
			e.printStackTrace();
			System.out.println("上传文件的总的大小超出限制的最大值！！");
		}
	catch (FileUploadException e) {
		System.out.println("上传文件失败");
		e.printStackTrace();
	}
	
	
	
 }

//设置唯一文件名
public String makeFileName(String fileName){
	
	//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	return	UUID.randomUUID().toString() + "_" + fileName;

}

//构造新目录
public String makeSaveFilePath(String Filename,String savePath){
	//得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
	 int hashcode = Filename.hashCode();
	 int dir1 = hashcode&0xf;//0--15
	 int dir2 = (hashcode&0xf0)>>4;//0--15
	 //构造新的保存目录
	 String dir = savePath + "\\" + dir1 + "\\" + dir2; //upload\2\3 upload\3\5
     //File既可以代表文件也可以代表目录    
	 File file = new File(dir);
	 //如果目录不存在
	 if(!file.exists()){
		 file.mkdirs();
	 }
	 
	 return dir;
}


//列出文件列表

public void showFileListLoad(HttpServletRequest request, HttpServletResponse response){
	
	//获取上传文件的目录
	String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	//存储要下载的文件名
	Map<String,String> fileNameMap = new HashMap<String, String>();
	//递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
	listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
	//将Map集合发送到listfile.jsp页面进行显示
	request.setAttribute("fileNameMap", fileNameMap);
	try {
		request.getRequestDispatcher("../jsp/testDownload.jsp").forward(request, response);
	} catch (ServletException | IOException e) {
		e.printStackTrace();
	}

}

public void listfile(File file,Map<String,String> map){
	if(!file.isFile()){
		File files[] = file.listFiles();
		for (File f : files) {
			listfile(f,map);
		}
	}
	else{
		//file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
		String realName = file.getName().substring(file.getName().indexOf("_") + 1);
		map.put(file.getName(), realName);
	}
}

}













