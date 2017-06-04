// 验证表单

//function validateForm(){
//
//if(document.loginForm.userName.value == ""){
//alert("please input the title!");
//document.loginForm.userName.focus();
//return false;
//}
//
//if(document.forms[0].userPassword.value == ""){ 
//alert("please input the content!");
//document.loginForm.userPassword.focus();
//return false;
//}
//return true;
//}


//function validateForm(){
//
//if(document.getElementById('userName').value == ""){
//	alert("please enter the userName");
//	document.getElementById('userName').focus();
//	return false;
//}
//if(document.getElementById('userPassword').value == ""){
//	alert("please enter the password");
//	document.getElementById('userPassword').focus();
//	return false;
//}
//	return true;
//}

function validateForm(){
	
 if($("#userName").val() == ""){
	 alert("please enter the userName");
     $("#userName").focus();
     return false;
 }	 
 if($("#userPassword").val() == ""){
	 alert("please enter the passWord");
     $("#userPassword").focus();
     return false;
 }	 

    
	return true;
}

$.ready();
