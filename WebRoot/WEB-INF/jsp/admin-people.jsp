<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>人员管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/mystyle.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->
	<div class="wrapper">
	<div class="container">
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-2 left">
				<%@ include file="admin-left.jsp"%>
			</div>
			<!--<div class="col-lg-2">-->


			<div class="col-md-10 form-group">

				${ searchForm }

				<table class="table table-condensed">
					<thead>
						<tr>
							<th>ID</th>
							<th>用户名</th>
							<th>姓名</th>
							<th>密码</th>
							<th>年龄</th>
							
							<th>性别</th>
							<th>邮箱</th>
							<th>证件号</th>
							<th>电话</th>
							<th>验证</th>
						</tr>
					</thead>
					<tbody>
						<jstl:forEach var="user" items="${ userList }">
							<tr>
								<td>${ user.id }</td>
								<td>${ user.nickName }</td>
								<td>${ user.realName }</td>
								<td>${ user.password }</td>
								<td>${ user.age }</td>
								<td><jstl:if test="${ user.sex }">女</jstl:if> <jstl:if
										test="${ !user.sex }">男</jstl:if></td>
								<td>${ user.email }</td>
								<td>${ user.icNumber }</td>
								<td>${ user.tel }</td>
								<td>${ user.checked }</td>
								<!-- 11 -->
								<td>
									<form action="CheckUser" method="post">
										<input type="hidden" name="userID" value="${ user.id }" /> <input
											type="submit" class="btn btn-default" value="认证" />
									</form>
								</td>
								<td>
									<form action="DelUser" method="post">
										<input type="hidden" name="userID" value="${ user.id }" /> <input
											type="submit" class="btn btn-default" value="删除" />
									</form>
								</td>
							</tr>
						</jstl:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
			<div class="push"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
