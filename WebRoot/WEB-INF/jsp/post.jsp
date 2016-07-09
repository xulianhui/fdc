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
			
			<div class="col-md-10">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>房屋ID</th>
							<th>房屋抬头</th>
							<th>照片路径</th>
						</tr>
					</thead>
					<tbody>
						<jstl:forEach var="house" items="${ houseList }">
							<tr>
								<td>${ house.id }</td>
								<td>${ house.houseTitle }</td>
								<td>${ house.img1 }</td>
								<td>
									<form action="Homepage-post" method="post">
										<input type="hidden" name="houseID" value="${ house.id }"/> <input
											type="text" name="toID" class="text-center" placeHolder="输入1-15的数字" />
										<input type="submit" value="推送" class="btn btn-default"/>
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
