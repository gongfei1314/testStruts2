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
 * @author ����
 * �����ϴ��ļ�����ʾ��Ҫ�����ļ����б�
 */
public class Upload_showList_TestAction extends HttpServlet {

@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        
	        String upLoad = "";
	        upLoad = request.getParameter("upLoad");
	        if((null == upLoad)||("".equals(upLoad))){
	        	 //��ʾ�ļ������б�
	              showFileListLoad(request,response);
	              
	        }
	        else if(upLoad.equals("fileUpLoad")){
	        	// �ļ��ϴ�
		        testUpload(request,response);
		        //ת�������б�
		        showFileListLoad(request,response);
		        
	        }

}



// * �򵥵��ļ��ϴ�
 /*
 public void testUpload(HttpServletRequest request, HttpServletResponse response){

String mesage = null;
	//��ȡ·��
	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	
	System.out.println(this.getServletContext());
	System.out.println(savePath);
	//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
     //1������һ��DiskFileItemFactory����
   DiskFileItemFactory factory = new DiskFileItemFactory(); 
    //2������һ���ļ��ϴ�������
    ServletFileUpload upload = new ServletFileUpload(factory); 
    upload.setHeaderEncoding("utf-8");
   // 3���ж��ύ�����������Ƿ��Ǳ�
    if(!ServletFileUpload.isMultipartContent(request)){
       //���򰴴�ͳ��ʽ��ȡ
    	return;
    }
   
  //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>����
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
			  mesage = "�ļ��ϴ��ɹ�";
			} catch (IOException e) {
			     mesage = "�ļ��ϴ�ʧ��";
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


 
// �Ż�����ļ��ϴ� 
public void testUpload(HttpServletRequest request, HttpServletResponse response){
	
	//�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
	String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	 //�ϴ�ʱ���ɵ���ʱ�ļ�����Ŀ¼
	String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
	File tempFile = new File(tempPath);
	if(!tempFile.exists()){
		tempFile.mkdirs();
	}
	//��Ϣ��ʾ
	String message = "";
	
	//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
    //1������һ��DiskFileItemFactory����
	DiskFileItemFactory factory = new DiskFileItemFactory();
	//���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼���С�
	factory.setSizeThreshold(1024*100);//���û������Ĵ�СΪ100KB�������ָ������ô�������Ĵ�СĬ����10KB
	//�����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
	factory.setRepository(tempFile);
	//2������һ���ļ��ϴ�������
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setProgressListener(new ProgressListener(){

		@Override
		public void update(long pByteRead, long pContentLongth, int arg2) {
			System.out.println("�ļ���С�� " + pByteRead + ",��ǰ�Ѵ���" + pByteRead);	
		}
	});
	upload.setHeaderEncoding("utf-8");
	upload.setFileSizeMax(1024*100);
	upload.setSizeMax(1024*1024);
	
	//3���ж��ύ�����������Ƿ����ϴ���������,multipart/form-data
	if(!ServletFileUpload.isMultipartContent(request)){
		return;
	}
	try {
	//4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
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
		System.out.println("�����ļ��������ֵ");
	}
	 catch (FileUploadBase.SizeLimitExceededException e){
			e.printStackTrace();
			System.out.println("�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ����");
		}
	catch (FileUploadException e) {
		System.out.println("�ϴ��ļ�ʧ��");
		e.printStackTrace();
	}
	
	
	
 }

//����Ψһ�ļ���
public String makeFileName(String fileName){
	
	//Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
	return	UUID.randomUUID().toString() + "_" + fileName;

}

//������Ŀ¼
public String makeSaveFilePath(String Filename,String savePath){
	//�õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
	 int hashcode = Filename.hashCode();
	 int dir1 = hashcode&0xf;//0--15
	 int dir2 = (hashcode&0xf0)>>4;//0--15
	 //�����µı���Ŀ¼
	 String dir = savePath + "\\" + dir1 + "\\" + dir2; //upload\2\3 upload\3\5
     //File�ȿ��Դ����ļ�Ҳ���Դ���Ŀ¼    
	 File file = new File(dir);
	 //���Ŀ¼������
	 if(!file.exists()){
		 file.mkdirs();
	 }
	 
	 return dir;
}


//�г��ļ��б�

public void showFileListLoad(HttpServletRequest request, HttpServletResponse response){
	
	//��ȡ�ϴ��ļ���Ŀ¼
	String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
	//�洢Ҫ���ص��ļ���
	Map<String,String> fileNameMap = new HashMap<String, String>();
	//�ݹ����filepathĿ¼�µ������ļ���Ŀ¼�����ļ����ļ����洢��map������
	listfile(new File(uploadFilePath),fileNameMap);//File�ȿ��Դ���һ���ļ�Ҳ���Դ���һ��Ŀ¼
	//��Map���Ϸ��͵�listfile.jspҳ�������ʾ
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
		//file.getName()�õ������ļ���ԭʼ���ƣ����������Ψһ�ģ���˿�����Ϊkey��realName�Ǵ����������ƣ��п��ܻ��ظ�
		String realName = file.getName().substring(file.getName().indexOf("_") + 1);
		map.put(file.getName(), realName);
	}
}

}













