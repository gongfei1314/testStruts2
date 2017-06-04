<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主页面(消费分析)</title>
<link href="../css/menu.css" type="text/css" rel="stylesheet">
<link href="../css/common.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="../js/menu.js"></script>
</head>

<body>
<!--菜单-->
<!--菜单-->
<div class="header">
<div style="width:950px; margin:0 auto;">
<div class="logo"><img src="../image/csc_05.png" width="382" height="82" class="JIATHIS_IMG_NO" ></div><!--logo-->
<div class="headRight">
<div class="right"><div style="padding-top:90%">您好，	<div id ="session" ><%=session.getAttribute("myname")%></div></div></div><!--telphone-->
<div class="clear"></div>
</div><!--headRight-->
<div class="clear"></div>
<div id="menu">
<div id="menuLeft"></div><!--menuLeft-->
<div id="menuC">
<ul class="qiehuan" id="myTab2">
<li class="active" id="myTab2_Title0" onMouseOver="nTabs('myTab2',this);"><a>我要记账</a></li>
<li class="normal" id="myTab2_Title1" onMouseOver="nTabs('myTab2',this);"><a>统计分析</a></li>
<li class="normal" id="myTab2_Title2" onMouseOver="nTabs('myTab2',this);"><a>智能分析</a></li>
</ul>
<div class="clear"></div>
</div><!--menuC-->
<div id="menuRight"></div><!--menuRight-->
<div class="clear"></div>
</div><!--menu-->

<div class="tabContent">
<div id="myTab2_Content0" class="none">
<ul class="subMenu">
<li><a href="../jsp/nowWriteCount.jsp">立刻记账</a></li>
</ul>
<div class="clear"></div>
</div><!--myTab1_Content0-->
<div id="myTab2_Content1" class="none">
<ul class="subMenu">
<li><a href="/testStruts2/jsp/totleConsume.jsp">消费统计</a></li>
<li><a href="main.jsp">消费分析</a></li>
</ul>
<div class="clear"></div>
</div><!--myTab1_Content0-->
<div id="myTab2_Content2" class="none">
<ul class="subMenu">
<li><a href="myConsume.jsp">我的消费</a></li>
</ul>
<div class="clear"></div>
</div><!--myTab1_Content0-->

</div><!--tabContent-->
</div>
</div>
<!--菜单-->
<!--内容-->
<div>
 <div style="width:950px; margin:0 auto; padding-top:20px">
    <div class="right">当前位置：统计分析 > 消费分析</div>
    <div class="clear"></div>
	<div style="margin-top:20px" >
	 <img src="../image/mainPic1.png" />
	</div>
	<div >
	 <img src="../image/mainPic2.png" />
	 </div>
	<div class="clear"></div>
	</div>
 </div>

  
<!--内容-->
<!--结尾-->
<div>
关于我们 |网站声明 
最终解释权归龚飞所有
</div>
<!--结尾-->
</body>
</html>