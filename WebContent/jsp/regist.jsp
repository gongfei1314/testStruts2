<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common.css" type="text/css"   rel="stylesheet" />
<link href="../css/regist.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/regist.js"></script>
<% String path = request.getContextPath(); %>
<title>注册账号</title>
</head>

<body  bgcolor="#CCCCCC">
<div class="back" >
 <div>
  用户注册
 </div>
 <form name ="regist" action= "<%=request.getContextPath() %>/registPack/regist.do" method="get" onsubmit="return validateForm()"  >
 <input type="hidden" id ="state" value = <%= request.getAttribute("flag") %> />
 <div class="regmain">
	 <div class="regwin">
	  <div class="left">姓&nbsp;&nbsp;&nbsp;&nbsp;名</div>
	  <div class="left"><input type="text" name="userName" /></div>
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">身份证号</div>
	  <div class="left"><input type="text" name ="identify"/></div> 
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">密&nbsp;&nbsp;&nbsp;&nbsp;码</div>
	  <div class="left"><input type="password" name = "password" /></div>
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">确认密码</div>
	  <div class="left"><input  type="password" name = "password2"/></div>
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">性&nbsp;&nbsp;&nbsp;&nbsp;别</div>
	  <div class="left"><input id = "man" type="radio"  checked="checked" name = "sex" value="man" />男&nbsp;<input  type="radio" name = "sex" value="woman"/>女</div>
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">年&nbsp;&nbsp;&nbsp;&nbsp;龄</div>
	  <div class="left"> <input  type="text" name="age" /></div>
	  <div class="clear"></div> 
	 </div>
	 <div class="regwin">
	  <div class="left">手机号码</div>
	  <div class="left"><input type="text"  name="mobileTel" /></div>
	  <div class="clear"></div> 
	 </div>
	 <div  class="regwin">
	  <div class="cancel" ><input  type="submit" value="提交注册" /></div>
	  <div class="cancel" ><input  type="button" value="重新填写" onclick="clearContent()" /></div>
	  <div class="clear"></div> 
	 </div>
  </div>
  </form>
</div>
</body>
</html>
