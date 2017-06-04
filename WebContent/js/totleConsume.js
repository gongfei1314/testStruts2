//查询

$(document).ready(function(){
	    query();
	$("#query").click(function(){
		query();
	});
	
	
})


/*
 * 查询消费记录
 */

function query(){
	
	$.ajax({
		url:"http://localhost:8080/testStruts2/queryBookPack/queryBooks.do",
		type:"post",
		data:{
		   "typeCode" : $("#classes select[name='consumeType']").val(),
		   "startTime" : $("#dateTimes ul li input[name='starTime']").val(),
		   "endTime" : $("#dateTimes ul li input[name='endTime']").val(),
			"object" : $("#otherTerm ul li textarea").val(),
		},
		dataType:"text", 
		success:function(data){
			alert(data);
//			var jsonData = JSON.parse(data);
			var jsonData = eval("("+data+")");
			var array = new Array();
			for(var i = 0;i<jsonData.length;i++){
				array[i] = jsonData[i];
			}
			if(array[0].object != ""){
				showQueryTable(array);
			}
		},
	    error:function(){
	    	alert("error")
	    }
		
	});
}

//显示查询的列表
function showQueryTable(array){
	$("#showTable").empty();
	$("#showTable").append("<tr>"+
		"<th>消费类型</th>"+
		"<th>消费对象</th>"+
		"<th>消费时间</th>"+
		"<th>金额</th>"+
		"<th>描述</th>"+
		"<th>消费地址</th>"+
		"<th>相关图片</th>"+
		"<th>消费参与人</th>"+
		"<th  width='90px'>操作</th>"+
		"</tr>"+
		""
	);
	for(var i = 0 ;i<array.length;i++){
		$("#showTable").append(
				"<tr>" +
				"<td>"+ array[i].typeName +"</td>"+
				"<td>"+ array[i].object +"</td>"+
				"<td>"+ array[i].dateTime +"</td>"+
				"<td>"+ array[i].money +"</td>"+
				"<td>"+ array[i].description +"</td>"+
				"<td>"+ array[i].address +"</td>"+
				"<td>"+ array[i].imagePath +"</td>"+
				"<td>"+ array[i].otherPersonCode +"</td>"+
				"<td><input type='button' onclick='editConsume(this)' value='编辑' id='"+ i +"'/> "+
				"<input  type='button' onclick='deleteConsme(this)' value='删除' id='"+ i +"'/></td>"+
				"</tr>"+
				"<input type = 'hidden' name='showTable"+ i + "' value = '"+ array[i].accountBookNum + "'/>"+
			 "");
	}

}

/**
 * 删除记录
 * @param obj
 */
function deleteConsme(obj){
	var i = obj.id;
//	var test =  document.getElementById("showTable"+i).value;
	var bookNum = $("#showTable input[name='showTable"+ i +"']").val();
    
    $.ajax({
    	url:"../editBookPack/deleteConsume.do",
    	type:"post",
    	data:{"accountBookNum":bookNum},
    	success:function(data){
            alert(data);
            query();
    	},
    	error:function(e){
    		alert(e);
    	}
    });
}
/*
 * 编辑记录
 */
function editConsume(obj){
	var i = obj.id;
	var bookNum = $("#showTable input[name='showTable"+ i +"']").val();
	alert(bookNum);
	window.location.href ="../editBookPack/queryById.do?number="+bookNum;
}



