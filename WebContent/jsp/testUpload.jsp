<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"  />
<title>上传文件</title>
</head>

<body>
<div class="back">
<form name="testForm" action="../action/Upload_showList_TestAction?upLoad=fileUpLoad" method="post" enctype="multipart/form-data" >
 <div>上传用户： <input type="text" name="userName"></div>
 <div>上传文件1：<input type="file" name="file1" /> </div>
 <div>上传文件2：<input type="file" name="file2" /> </div>
 <input type="submit" value="提交">
 </form>
 </div>
</body>
</html>
