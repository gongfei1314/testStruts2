$(document).ready(function(){

	refree();
	
	
	$("#editer").click(function(){

		editCountBook();
	});
	
	$("#cancel").click(function(){
		
		window.location.href="../jsp/totleConsume.jsp";
	});
	
	
});

/*
 * 初始化
 */
function refree(){
	var selectFlag = $("#nowWriteFrm input[name='selectFlag']").val();
    $("#accountType").val(selectFlag);

}
/**
 * 修改记录
 */
function editCountBook(){
	$.ajax({
		url:"../editBookPack/editAccountBook.do",
		data:$("#nowWriteFrm").serialize(),
		type:"post",
		success:function(data){
//		    var flag = eval("("+ data +")");
			alert(data);
			window.location.href="../jsp/totleConsume.jsp";
		},
	    error:function(error){
	    	alert("系统错误");
	    }
	});
	
	
}

//
//function clearContent(){
//	
//	 $("#nowWriteFrm select[name='accountType']").val("1");
//	 $("#nowWriteFrm input[name='money']").val("");
//     $("#nowWriteFrm input[name='object']").val("");
//	 $("#nowWriteFrm input[name='time']").val("");
//	 $("#nowWriteFrm input[name='descript']").val("");
//	 $("#nowWriteFrm input[name='address']").val("");
//	 $("#nowWriteFrm input[name='file']").val("");
//	 $("#nowWriteFrm input[name='otherPer']").val("");
//
//}
