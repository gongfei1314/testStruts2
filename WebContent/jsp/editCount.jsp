<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改记账</title>
<link href="../css/menu.css" type="text/css" rel="stylesheet" />
<link href="../css/common.css" type="text/css" rel="stylesheet" />
<link href="../css/nowWriteCount.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script language="javascript" type="text/javascript" src="../js/menu.js"></script>
<script type="text/javascript" language="javascript" src="../js/editCount.js"></script>

</head>


<body>
<!--菜单-->
<div class="header">
<div style="width:950px; margin:0 auto;">
<div class="logo"><img src="../image/csc_05.png" width="382" height="82" class="JIATHIS_IMG_NO" ></div><!--logo-->
<div class="headRight">
<div class="right"><div style="padding-top:90%">您好，	<div id ="session" ><%=session.getAttribute("myname") %></div></div></div><!--telphone-->
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
<li><a href="nowWriteCount.jsp">立刻记账</a></li>
</ul>
<div class="clear"></div>
</div><!--myTab1_Content0-->
<div id="myTab2_Content1" class="none">
<ul class="subMenu">
<li><a href="totleConsume.jsp">消费统计</a></li>
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

 <div style="width:950px; margin:0 auto; padding-top:20px">
  <div class="right">当前位置：我要记账 > 立即记账</div>
  <div class="clear"></div>
  <div class="myConsume">
		  <div>
			 <div class="left">记录消费</div>
			 <div class="clear"></div>
		  </div>
<form id ="nowWriteFrm" method = "post"  > 
<input type="hidden" name="accountNum" value='<%=request.getAttribute("accountId") %>' />
<input  type="hidden" name="selectFlag" value='<%=request.getAttribute("typeName") %>' />
	  <div class="back"> 
	   <div class="regmain"> 
		 <div class="regwin">
		  <div class="left">消费类型</div>
		  <div class="left">
		      &nbsp;&nbsp;
		      <select name ="typeCode" id = "accountType" style="width: 140px;">
		         <option value="1">生活用品</option>
		         <option value="2">服装</option>
		         <option value="3">电子产品</option>
		         <option value="4">培训费用</option>
		      </select>
		  </div>
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">消费对象</div>
		  <div class="left"><input type="text" name ="object" value='<%=request.getAttribute("object") %>' /></div> 
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">消费时间</div>
		  <div class="left"><input type="text" name="dateTime"  value='<%=request.getAttribute("time") %>' /></div> 
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">金&nbsp;&nbsp;&nbsp;&nbsp;额</div>
		  <div class="left"><input type="text"  name="money"  value='<%=request.getAttribute("money") %>' /></div>
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">描&nbsp;&nbsp;&nbsp;&nbsp;述</div>
		  <div class="left"><input  type="text" name="description"  value='<%=request.getAttribute("description") %>' /></div>
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">地&nbsp;&nbsp;&nbsp;&nbsp;址</div>
		  <div class="left"><input type="text" name="address"  value='<%=request.getAttribute("address") %>' /></div>
		  <div class="clear"></div> 
		 </div>
		 <div class="regwin">
		  <div class="left">参&nbsp;与&nbsp;人</div>
		  <div class="left"><input type="text" name ="otherPersonCode"  value='<%=request.getAttribute("otherPersonCode") %>'  /></div>
		  <div class="clear"></div> 
		 </div>
	   </div>
	  </div>
  </form> 
 
       
      <form action="" >
          <div class="marginleft">
       	   <div class="regwin" >
		   <div class="left">相&nbsp;&nbsp;&nbsp;&nbsp;片</div>
		   <div class="left"> <input type="file" name="file"/></div>
		   <div class="clear"></div> 
		   </div>
		 </div> 
      </form>
      <div class="marginleft">
        <div  class="regwin high">
		  <div class="left" ><input id="editer" type="button" value="保存修改"  /></div>
		  <div class="left" ><input id="cancel" type="button" value="&nbsp&nbsp取&nbsp&nbsp消&nbsp&nbsp" /></div>
		  <div class="clear"></div> 
		</div>
	 </div>

 </div>
</div>

<!--内容-->
<!--结尾-->
<div class="clear"></div>
<div class="tail">
关于我们 |网站声明 
最终解释权归龚飞所有
</div>
<!--结尾-->
</body>
</html>
