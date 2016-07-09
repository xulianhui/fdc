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

<title>评论管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
			<div class="house-list col-md-10">
				<form action="ShByName" method="post" class="form-inline">
					用户姓名：<input type="text" name="shUserNameStr" /> <input
						type="submit" value="查找评论" class="btn btn-default" />
					<p>${ resultMessage }</p>
				</form>

				<!-- jstl -->
				<jstl:forEach var="cmt" items="${ cmtList }">
					<div class="row list-group-item">
						<form action="DelCmt" method="post">
							<div class="col-md-10">
								<p>
									<em>用户（${ cmt.comterId }）评论信息（${ cmt.comtedId }）道：</em>
								</p>
								${ cmt.content } @${ cmt.conTime }
							</div>
							<div class="col-md-2">
								<input type="hidden" name="cmtId" value="${ cmt.id }" /> <input
									type="submit" class="btn btn-defalut" value="删除评论" />
							</div>
						</form>
					</div>
				</jstl:forEach>
				<!-- end jstl -->

			</div>
		</div>
	</div>
			<div class="push"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
