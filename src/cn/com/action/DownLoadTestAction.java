package cn.com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadTestAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            fileLoad(request,response);
	}
	
	public void fileLoad(HttpServletRequest request, HttpServletResponse response){
		

		try {
			
			//�õ�Ҫ���ص��ļ���
			String fileName = request.getParameter("filename");
			fileName = new String(fileName.getBytes("iso8859-1"),"utf-8");
			//�ϴ����ļ����Ǳ�����/WEB-INF/uploadĿ¼�µ���Ŀ¼����
			String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");
			//ͨ���ļ����ҳ��ļ�������Ŀ¼
			String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
			System.out.println(path);
			//�õ�Ҫ���ص��ļ�
			File file = new File(path + "\\" + fileName);
			//����ļ�������
			if(!file.exists()){
				request.setAttribute("message", "��Ҫ���ص��ļ���ɾ��");
				try {
					request.getRequestDispatcher("../jsp/testDownload.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
				
				return;
			}
			
			try {
				//�����ļ���
				String realname = fileName.substring(fileName.indexOf("_") + 1);
//				response.setContentType("application/x-download; charset=utf-8");//1
				//������Ӧͷ��������������ظ��ļ�
//				response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname , "utf-8"));
				response.setHeader("content-disposition", "attachment;filename=" + new String(realname.getBytes("gb2312"),"ISO8859-1"));
				//��ȡҪ���ص��ļ��������浽��������
				InputStream in = new FileInputStream(new File(path + "\\" + fileName));
				OutputStream out;
				out = response.getOutputStream();
				byte[] b = new byte[1024];
				int len = 0;
				while((len = in.read(b)) > 0){
					out.write(b,0,len);
				}
				in.close();
				out.close();
				
		
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
public String findFileSavePathByFileName(String filename,String saveRootPath){
	int hashCode = filename.hashCode();
	int dir1 = hashCode&0xf; //0--15
	int dir2 = (hashCode&0xf0)>>4; //0--15
	String dir = saveRootPath + "\\" + dir1 + "\\" + dir2 ;  // upload\2\3 upload\3\5
	File file = new File(dir);
	if(!file.exists()){
		//����Ŀ¼
		file.mkdirs();
	}
	return dir;
  }

}
