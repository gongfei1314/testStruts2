<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>消费统计</title>
<link href="../css/menu.css" type="text/css" rel="stylesheet" />
<link href="../css/common.css" type="text/css" rel="stylesheet" />
<link href="../css/totleConsume.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script language="javascript" type="text/javascript" src="../js/menu.js"></script>
<script language="javascript" type="text/javascript" src="../js/totleConsume.js"></script>
</head>


<body>
<input type="text" name="jsonBookList.">
<!--菜单-->
<div class="header">
<div style="width:950px; margin:0 auto;">
<div class="logo"><img src="../image/csc_05.png" width="382" height="82" class="JIATHIS_IMG_NO" ></div><!--logo-->
<div class="headRight">
<div class="right"><div style="padding-top:90%">您好,<div id ="session" ><%=session.getAttribute("myname") %></div></div></div><!--telphone-->
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
<div>
   <div style="width:950px; margin:0 auto; padding-top:20px">
       <div class="right">当前位置：统计分析 > 消费统计</div>
       <div class="clear"></div>
	   <div><!--统计内容-->
	      <div id="leftwin">
		      <div id="classes">
			      <div><p>选择类型:</p></div>
				  <div >
				  <select name="consumeType" id = "consumeType">
				       <option value="0">全部</option>
		               <option value="1">生活用品</option>
		               <option value="2">服装</option>
		               <option value="3">电子产品</option>
		               <option value="4">培训费用</option>
				  </select>
				  
<!--  			    <ul>
				       <li>类型1</li>
					   <li>类型2</li>
					   <li>类型3</li>
					   <li>类型4</li>
				    </ul>
				    -->	
				  </div>
			  </div>
			  <div id="dateTimes">
			      <div><p>选择时间：</p></div>
				  <div>
				    <ul>
				       <li>开始时间：<input name="starTime" type="text"></li>
					   <li>结束时间：<input name="endTime" type="text"></li>
				    </ul>
				  </div>
			  </div>
			  <div id="otherTerm">
			      <div><p>其他条件：</p></div>
			      <div>
			        <ul>
			          <li>
			             <textarea rows="" cols="" ></textarea>
			          </li>
			        </ul>
			      </div>

		      </div>
		      <div id="search">
		         <button id = "query">查询</button>
		         <button>取消</button>
		      </div>
		  </div>
		  <div id="rightwin">
	
		  <table id = "showTable">
				 <tr>
				    <th>消费类型</th>
					<th>消费对象</th>
					<th>消费时间</th>
					<th>金额</th>
					<th>描述</th>
					<th>消费地址</th>
					<th>相关图片</th>
					<th>消费参与人</th>
					<th  width="90px">操作</th>
				 </tr>
		<!--  <tr>
				    <td>服装</td>
				    <td>羽绒服</td>
					<td>2015-11-11</td>
				    <td>329.00</td>
				    <td>京东购买羽绒服</td>
				    <td>新兴花园</td>
					<td>参考图片</td>
				    <td>xxx、xxx</td>
				    <td><input type="button"  value="编辑"/> <input  type="button"  value="删除" /></td>												
				 </tr>
				 <tr>
				    <td>日常用品</td>
				    <td>牙膏</td>
					<td>2015-11-12</td>
				    <td>5.00</td>
				    <td>宾隆超市</td>
				    <td>在宾隆超市购买牙膏</td>
					<td>参考图片</td>
				    <td>无</td>	
					<td><input type="button"  value="编辑"/> <input  type="button"  value="删除" /></td>
				 </tr>
				  <tr>
				    <td>健身器材</td>
				    <td>漂移板</td>
					<td>2015-11-11</td>
				    <td>120.00</td>
				    <td>天猫商城</td>
				    <td>在乌当监督指挥中心购买漂移板</td>
					<td>参考图片</td>
				    <td>xxx</td>
					<td><input type="button"  value="编辑"/> <input  type="button"  value="删除" /></td>	
				 </tr>
				  -->		
			  </table>
			</div> 
			<div class="clear"></div>  
	   </div><!--统计内容-->
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
