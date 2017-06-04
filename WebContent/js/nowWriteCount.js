$(document).ready(function(){
	
	$("#submit").click(function(){

		addCountBook();
//		upLoadFile();
	});
	
	$("#redo").click(function(){

		clearContent();
	});
	
	
});


//增加文件部分
function addCountBook(){
	$.ajax({
		url:"http://localhost:8080/testStruts2/addBookPack/addConsume.do",
		data:$("#nowWriteFrm").serialize(),
		type:"post",
		success:function(data){
//		    var flag = eval("("+ data +")");
			alert(data);
			clearContent();
 
		},
	    error:function(error){
	    	alert("系统错误");
	    }
	});
	
/*	var jsonJS = {"name":"gongfei","sex":"man","age":"23","identity":"522132"};
	$.ajax({
		url:"../action/EditAction",
		data:JSON.stringify(jsonJS),
		data:{"name":"龚飞","sex":"man","age":"23","identity":"522132"},
		data:$("#nowWriteFrm").serialize(),
		type:"get",
		success:function(data){
			alert(data);
			var per = eval("("+ data +")");
		    var per =	JSON.parse(data);
            alert(per.name);
		},
	    error:function(error){
	    	alert("error");
	    }
	});
	*/
	
}

//清空记录
function clearContent(){
	
	 $("#nowWriteFrm select[name='accountType']").val("1");
	 $("#nowWriteFrm input[name='money']").val("");
     $("#nowWriteFrm input[name='object']").val("");
	 $("#nowWriteFrm input[name='time']").val("");
	 $("#nowWriteFrm input[name='descript']").val("");
	 $("#nowWriteFrm input[name='address']").val("");
	 $("#nowWriteFrm input[name='file']").val("");
	 $("#nowWriteFrm input[name='otherPer']").val("");

}

//上传文件
function upLoadFile(){

	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        
    }
	if(xmlhttp != null){
	    xmlhttp.onreadystatechanges = function(){
	    	if((xmlhttp.readystate = 4)&&(xmlhttp.states = 200)){
	    		alert(xmlhttp.responseText);
	    	}
	    }
	}
	   xmlhttp.open("post","../action/UploadAction",true);
	   xmlhttp.setRequestHeader("Content-type","multipart/form-data");
	   xmlhttp.send();
	}

