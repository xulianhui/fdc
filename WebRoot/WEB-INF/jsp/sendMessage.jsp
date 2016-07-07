<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function goregedit() {
		window.location.href("regedit.jsp");
	}
	function checkmail() {
		var email = document.getElementById("useremail");
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!myreg.test(email.value)) {
			alert("请输入正确的用户邮箱！");
		}
	}
</script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
<title></title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
		<div class="container">
			<div class="container">
				<form method="post" action="sendMS">
					<div class="form-group">
						<div class="row col-lg-12">
							<div class="col-md-3">
								<label class="col-lg-offset-3">Title</label>
							</div>
							<input class="col-md-4" type="text" placeholder="title"
								name="mail.title" required="true" />
							<input name="mail.readFlag"  value="0"  type="hidden" />
						</div>
					</div>
					<div class="form-group">
						<div class="row col-lg-12">
							<div class="col-md-3">
								<label class="col-lg-offset-3">To user:</label>
							</div>
							<input class="col-md-4" type="text" placeholder="to user" name="mail.userToId"
								value="${toId }" readonly="true" />
						</div>
					</div>
					<div class="form-group">
						<div class="row col-lg-12">
							<div class="col-md-3">
								<label class="col-lg-offset-3">内容</label>
							</div>

							<textarea class="col-md-9" rows="16" required="true"
								name="mail.mailContent"></textarea>
						</div>
					</div>
					<div class="form-grou ">
						<div class="row">
							<div class="col-lg-12">
								<input class="col-lg-1 col-lg-offset-5" type="reset" value="重置" />
								<input class="col-lg-1" type="submit" value="发送" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="push"></div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>