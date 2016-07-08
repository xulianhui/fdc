<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyles.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
<script type="text/javascript">
    var nickname_state = false;
    var email_state = false;
    var psw_state = false;
    var psw2_state = false;
function checknickname(){
	nickname_state = false;
	var nickname=document.getElementById("usernickname");
	var myreg=/^[a-zA-z][a-zA-Z0-9_]{2,9}$/;	
	if(!myreg.test(nickname.value)){
	${"labelnickname"}.innerHTML = "提示 用户名至少一个字母开头，最少包含两位！";
	}else{
	${"labelnickname"}.innerHTML ="ok";
		nickname_state=true;
	}
}
function checkpwd(){
	psw_state = false;
	var pwd=document.getElementById("userpwd");
	${"labelpwd"}.innerHTML ="ok";	
	var re = /[^\w\u4e00-\u9fa5]/g;
	if (re.test(pwd.value)) {
        ${"labelpwd"}.innerHTML = "含有非法字符";
        psw_state = false;
    } else if (pwd.value == "") {
        ${"labelpwd"}.innerHTML = "不能为空";
        psw_state = false;
    } else if (pwd.value.length > 25) {
        ${"labelpwd"}.innerHTML = "不能超出25个字符";
        psw_state = false;
    } else if (pwd.value.length < 6) {
        ${"labelpwd"}.innerHTML = "不能少于6个字符";
        psw_state = false;
    } else {
        name_msg.innerHTML = "OK!";
        psw_state=true;
    }
}
function checkrpwd(){
	psw2_state = false;
	var pwd=document.getElementById("userpwd");
	var rpwd=document.getElementById("userrpwd");
	if(rpwd.value==""){
	${"labelrpwd"}.innerHTML = "请确认密码";
	}else if(pwd.value!=rpwd.value){
	${"labelrpwd"}.innerHTML ="和第一次密码不符";
	}else if(pwd.value==rpwd.value){
		${"labelrpwd"}.innerHTML="ok";
		psw_state=true;
		psw2_state=true;
	}
}
function setsubmit(){
		if(psw_state&&psw2_state&&nickname_state&&email_state)
		  return true;
		else
		  return false;
}
	function  checkmail() {
		email_state = false;
		var email = document.getElementById("userreemail");
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!myreg.test(email.value)) {
			${"labelemail"}.innerHTML = "提示\n\n请输入有效的E_mail！";
		} else {	
			$.ajax({
				url : 'um!checkemail',
				type : 'post',
				data : {
					email : email.value
				},
				async : false, //默认为true 异步   
				error : function() {
					alert('error');
				},
				success : function(data) {
					
					if (data.checkresult == "ok"){
							email_state=true;
							${"labelemail"}.innerHTML = data.checkresult;
						}
					if (data.checkresult != "ok")
						if(data.checkresult != null)
						${"labelemail"}.innerHTML = data.checkresult;
						else{
						${"labelemail"}.innerHTML = "数据库连接错误,请致电管理员,谢谢合作!";	
						}
				}
			});
		}
		return false;
	}
</script>
<title></title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->
	<div class="wrapper">
		<div class="container">
			<form action="um!regedit" class="col-md-6 col-md-offset-3"
				method="post" style="padding-top: 20px;">
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">用户名</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" placeholder="用户名" onblur="checknickname();setsubmit();"
								id="usernickname" name="users.nickName" />
						</div>
						<div class="col-lg-4">
							<label id="labelnickname"></label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">email</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" placeholder="email"
								name="users.email" onblur="checkmail();setsubmit();" id="userreemail" />
						</div>
						<div class="col-lg-4">
							<label id="labelemail"></label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">密码</label>
						</div>
						<div class="col-lg-6">
							<input type="password" class="form-control" placeholder="密码" id="userpwd" onblur="checkpwd();setsubmit();"
								name="users.password" />
						</div>
						<div class="col-lg-4">
							<label id="labelpwd"></label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">确认密码</label>
						</div>
						<div class="col-lg-6">
							<input type="password" class="form-control" placeholder="确认密码"  id="userrpwd"  onchange="checkrpwd();setsubmit();" onkeyup="setsubmit();"/>
						</div>
						<div class="col-lg-4">
							<label id="labelrpwd"></label>
						</div>
					</div>
				</div>
				<div class="form-group" style="display: none;">
					<div class="row">
						<div class="col-lg-2">
							<label for="">类型</label>
						</div>
						<div class="col-lg-6">
							<input type="text" name="users.type" value="0"
								class="form-control" name="users.type" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-4  form-inline col-lg-offset-3">
							<input type="submit" class="btn btn-default pull-right"
								id="btsubmit" value="注册"  onclick="return setsubmit();" /> <input type="reset"
								class="btn btn-default pull-left" value="重置" />
						</div>
						<div class="col-lg-3 "></div>
					</div>
				</div>
			</form>
		</div>
		<div class="container">
		
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>