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
<title>房屋信息审核</title>

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
			<div class="col-lg-2 left">
				<%@ include file="admin-left.jsp"%>
			</div>
			<!--<div class="col-lg-2">-->

			${ shForm }

			<div class="col-md-10">
				<table class="table table-condensed">
					<jstl:forEach var="house" items="${ houseList }">
						<th colspan="2">${ house.houseTitle }</th>
						<tr> <!-- 1 -->
							<td>信息 ID：</td>
							<td>${ house.id }</td>
						</tr>
						<tr> <!-- 2 -->
							<td>发布人 ID：</td>
							<td>${ house.userId }</td>
						</tr>
						<tr> <!-- 3 -->
							<td>信息类型：</td>
							<td><jstl:if test="${ house.newsType == 0 }">
									出租
								</jstl:if> <jstl:if test="${ house.newsType == 1 }">
									出售
								</jstl:if></td>
						</tr>
						<tr> <!-- 4 -->
							<td>房屋地址：</td>
							<td>${ house.houseReg }${ house.houseAddDetail }</td>
						</tr>
						<tr> <!-- 5 -->
							<td>价格：</td>
							<td>${ house.housePrice }元<jstl:if
									test="${ house.newsType == 0 }">
									/月
								</jstl:if>
							</td>
						</tr>
						<tr> <!-- 6 -->
							<td>住房面积：</td>
							<td>${ house.houseArea }平方米</td>
						</tr>
						<tr> <!-- 7 -->
							<td>信息状态：</td>
							<td><jstl:if test="${ house.houseNewsStatus == 0 }">
										未审核
								</jstl:if> <jstl:if test="${ house.houseNewsStatus == 1 }">
										审核通过
								</jstl:if> <jstl:if test="${ house.houseNewsStatus == 2 }">
										已经下架
								</jstl:if></td>
						</tr>
						<tr> <!-- 8 -->
							<td>
								<form action="HouseNews-check" method="post">
									<input type="hidden" name="cekHouseID" value="${ house.id }" />
									<input type="submit" value="认证" class="btn btn-block" />
								</form>
							</td>
							<td>
								<form action="HouseNews-delete" method="post">
									<input type="hidden" name="delHouseID" value="${ house.id }" />
									<input type="submit" value="删除" class="btn btn-block" />
								</form>
							</td>
						</tr>
					</jstl:forEach>
				</table>
			</div>

		</div>

	</div>
			<div class="push"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
