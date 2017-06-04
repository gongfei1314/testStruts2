// 验证表单
function validateForm(){

if(document.regist.userName.value == ""){
	alert("please input the name!");
	document.regist.userName.focus();
	return false;
	}

if(document.forms[0].identify.value == ""){ 
	alert("please input the identify!");
	document.regist.identify.focus();
	return false;
	}

if(document.forms[0].password.value != document.forms[0].password2.value){
	alert("you have input not same password!");
	document.regist.password.focus();
	return false;
	}


return true;
}


//清空表单
function clearContent(){
	alert("test");
	document.regist.userName.value = "";
	document.regist.identify.value ="";
	document.regist.password.value = "";
	document.regist.password2.value = "";
	document.getElementById("man").checked = "checked";
	document.regist.age.value = "";
	document.regist.mobileTel.value = "";
}

//注册成功后显示
$(document).ready(function(){
	if($("#state").val() == 1 ){
		alert("注册成功");
	    location.href = "../jsp/login.jsp" 
	}
});




