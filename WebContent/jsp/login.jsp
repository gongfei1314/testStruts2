<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link href="../css/common.css"  type="text/css" rel="stylesheet"/>
<link href="../css/login.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/login.js"></script>

</head>

<body>
<div class="back">
<form name="loginForm" action="<%=request.getContextPath()%>/loginPack/login.do" method="post" onsubmit="return validateForm()" >
<div id="loginDiv">
   <div id="loginBigwin">
      <div class="loginwin">
	    <div class="center" id="textUser">用户登录</div>
	  </div>
	  <div class="loginwin">
	    <div class="left"><img src="../image/username.png" /></div>
		<div class="left"><input id="userName"  name="userName"  type="text" value="请输入用户名" /></div>
		<div class="clear"></div>
	  </div>
	  <div class="loginwin">
	     <div class="left"><img src="../image/userpassword.png" /></div>
		 <div class="left"> <input id="userPassword" name="userPassword"  type="password" /> </div>
		 <div class="clear"></div>
	  </div>
	  <div class="loginwin">
      <!--  <div id="loginBtn"><a href="main.html">登录</a></div>  -->   
         <input id="loginBtn" type="submit" value="登录" />
	  </div>
	  <div class="loginwin">
		   <div class="left" style="padding-left:30px"><a href="regist.jsp" >注册账号</a></div>
		   <div class="right" style="padding-right:30px"><a href="#">忘记密码</a></div>
		   <div class="clear"></div>
	  </div>
   </div>
 </div>
 </form>
    
 </div>
</body>
</html>
