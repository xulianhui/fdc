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


</head>

<body>

	<p>plz login</p>

	<form action="AdminsLogin!login" method="post">
		<ul>
			<li><input type="text" name="admins.userName" /></li>
			<li><input type="password" name="admins.password" /></li>
			<li><input type="submit" /></li>
		</ul>
	</form>

	<p>${ loginMessage }</p>
</body>
</html>
