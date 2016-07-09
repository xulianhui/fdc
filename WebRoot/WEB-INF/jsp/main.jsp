<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<base href="<%=basePath%>">

<title>wanted</title>

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
		<table class="table">
			<jstl:forEach var="WUPair" items="${ WUList }">
				<th colspan="2">
					${ WUPair.second.nickName } 要
					<jstl:if test="${ WUPair.first.wantedType }">
							买房
					</jstl:if>
					<jstl:if test="${ !WUPair.first.wantedType }">
							租房
					</jstl:if>
				</th>
				<tr>
					<td>我的联系电话是</td>
					<td>${ WUPair.first.userTel }</td>
				</tr>
				<tr>
					<td>我最高能接受的价格是</td>
					<td>
						${ WUPair.first.maxPrice } 元
						<jstl:if test="${ !WUPair.first.wantedType }">
							/ 月
						</jstl:if>
					</td>
				</tr>
				<tr>
					<td>我要住的地方不能小于</td>
					<td>${ WUPair.first.minArea } 平方米</td>
				</tr>
				<tr>
					<td>我要住的地方不能大于</td>
					<td>${ WUPair.first.maxArea } 平方米</td>
				</tr>							
				<tr>
					<td colspan="2">总而言之：${ WUPair.first.details }</td>
				</tr>
			</jstl:forEach>
		</table>
	</div>
</body>
</html>
