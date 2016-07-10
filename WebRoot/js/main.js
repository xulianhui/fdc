function goregedit(){
	window.location.href("regedit.jsp");
}
function checkmail(){
	var email = document.getElementById("useremail");
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if (!myreg.test(email.value)) {
		alert("请输入正确的邮箱地址");
	}
}
function shelve(houseNewsId){
	if(houseNewsId==null){
		alert("错误的房屋信息");
	}
	else{
	$.ajax({
		url : 'shelves',
		type : 'post',
		data : {
			houseNewsId : houseNewsId
		},
		async : false, //默认为true 异步   
		error : function() {
			alert('error');
		},
		success : function(data) {
		}
	});
	}
}

function go_js(ss){
	if(ss==null){
		alert("请先登录，在查看相关信息！");
		return false;
	}else{
		alert("11111111111111");
		return true;
	}
}