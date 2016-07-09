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
</head>

<body>

	<div class="container">
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-2 left">
<!-- 				<%@ include file="admin-left.jsp"%> -->
			</div>
			<!--<div class="col-lg-2">-->


			<div class="col-md-10 form-group">

				${ searchForm }

<!-- 				<form action="" method="post" class="form-inline"> -->
<!-- 					用户 ID： <input type="text" name="shUserIdStr" class="form-control" /> -->
<!-- 					<input type="submit" value="查找评论" class="btn btn-default" /> -->
<!-- 					<p>${ resultMessage }</p> -->
<!-- 				</form> -->

<!-- 				${ userList.size() } -->
<!-- 				${ userList.get(0).getNickName() } -->
<!-- 				${ userID } -->
<!-- 				<jstl:if test="${ null == userList.get(0) }"> -->
<!-- 					NULL! -->
<!-- 				</jstl:if> -->
<!-- 				<p>23</p> -->

				<table class="table table-condensed">
					<jstl:forEach var="user" items="${ userList }">
						<tr>
							<td>用户ID</td>
							<td>${ user.id }</td>
						</tr>
						<tr>
							<td>用户名</td>
							<td>${ user.nickName }</td>
						</tr>
						<tr>
							<td>真实姓名</td>
							<td>${ user.realName }</td>
						</tr>
						<tr>
							<td>密码</td>
							<td>${ user.password }</td>
						</tr>
						<tr>
							<td>性别</td>
							<td><jstl:if test="${ user.sex }">女</jstl:if> <jstl:if
									test="${ !user.sex }">男</jstl:if></td>
						</tr>
						<tr>
							<td>年龄</td>
							<td>${ user.age }</td>
						</tr>
						<tr>
							<td>证件号码</td>
							<td>${ user.icNumber }</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td>${ user.tel }</td>
						</tr>
						<tr>
							<td>电子邮箱</td>
							<td>${ user.email }</td>
						</tr>
						<tr>
							<td>是否通过验证</td>
							<td>${ user.checked }</td>
						</tr>

						<tr>
							<td>
								<form action="CheckUser" method="post">
									<input type="hidden" name="userID" value="${ user.id }" /> <input
										type="submit" class="btn btn-block" value="认证" />
								</form>
							</td>
							<td>
								<form action="DelUser" method="post">
									<input type="hidden" name="userID" value="${ user.id }" /> <input
										type="submit" class="btn btn-block" value="删除" />
								</form>
							</td>
						</tr>
					</jstl:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
