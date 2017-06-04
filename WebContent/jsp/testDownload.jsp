<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />
<title>下载文件列表页面</title>
</head>

<body>
 <div class="back">
   <!-- 遍历hashmap集合 --> 
   <c:forEach var="me" items="${fileNameMap}">
   <c:url value="/action/DownLoadTestAction" var = "downurl">
         <c:param name="filename" value="${me.key}"></c:param>
         <c:param name="fileList" value="showFileList"></c:param>
      </c:url>
      <div>
      ${me.value} <a href="${downurl}">下载</a>
      </div>
   </c:forEach>
  
 </div>
</body>
</html>
