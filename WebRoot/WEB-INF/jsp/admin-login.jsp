<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>admin-login</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>

<body>

	<center>
	<div class="center" style="padding-top: 60px;">
		<h2 style="padding-bottom: 20px">Admin login</h2>
		<form action="AdminsLogin!login" method="post">
			<div class="row">
				<div class="form-group"><input type="text" name="admins.userName" /></div>
				<div class="form-group"><input type="password" name="admins.password" /></div>
				<div class="form-group"><input type="submit" /></div>
			</div>
		</form>
	</div>
	</center>

	<p>${ loginMessage }</p>
</body>
</html>
