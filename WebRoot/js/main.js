function goregedit(){
	window.location.href("regedit.jsp");
}
function checkmail(){
	var email = document.getElementById("useremail");
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (!myreg.test(email.value)) {
		alert("请输入正确的用户邮箱！");
	}
}