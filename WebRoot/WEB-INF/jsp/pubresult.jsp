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
<style type="text/css">
.col-center-block {
    float: none;
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
<title></title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->
	<div class="wrapper">
		<div class="container alert-success center-block" id="success" style="display:<%=session.getAttribute("user")!=null?"block":"none"%>">
			<div class="row ">
				<div class="col-lg-4 col-center-block " style="text-align:center">
					<h3>发布成功</h3>
				</div>
			</div>
			<div class="row">
			<div class="col-lg-5 col-center-block" style="text-align:center">
				<a href="#">进入个人中心</a>
				<a href="pubnews.jsp">继续发布</a>
				</div>
			</div>
		</div>
			<div class="container alert-danger center-block" id="failed" 
			style="display:<%=session.getAttribute("user")!=null?"none":"block"%>">
			<div class="row ">
				<div class="col-lg-4 col-center-block " style="text-align:center">
					<h3>请先登陆，再发布房源。</h3>
				</div>
			</div>
			<div class="row">
			<div class="col-lg-5 col-center-block" style="text-align:center">
				<a href="regedit.jsp">注册</a>
				<a href="found.jsp">忘记密码？</a>联系管理员
				</div>
			</div>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>