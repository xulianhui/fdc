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
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->

	<div class="wrapper">
	<div class="container">
		<div class="row col-md-8 col-md-offset-2">
			<jstl:forEach var="WUPair" items="${ WUList }">
				
			<table class="table" style="border:solid 1px #FFF;">
				<th colspan="2" >
					${ WUPair.second.nickName } 要
					<jstl:if test="${ WUPair.first.wantedType }">
							买房
					</jstl:if>
					<jstl:if test="${ !WUPair.first.wantedType }">
							租房
					</jstl:if>
				</th>
				<tr>
					<td style="border-right: solid 2px #FFF;">我的联系电话是</td>
					<td>${ WUPair.first.userTel }</td>
				</tr>
				<tr>
					<td style="border-right: solid 2px #FFF;">我最高能接受的价格是</td>
					<td>
						${ WUPair.first.maxPrice } 元
						<jstl:if test="${ !WUPair.first.wantedType }">
							/ 月
						</jstl:if>
					</td>
				</tr>
				<tr>
					<td style="border-right: solid 2px #FFF;">我要住的地方不能小于</td>
					<td>${ WUPair.first.minArea } 平方米</td>
				</tr>
				<tr>
					<td style="border-right: solid 2px #FFF;">我要住的地方不能大于</td>
					<td>${ WUPair.first.maxArea } 平方米</td>
				</tr>							
				<tr>
					<td colspan="2">总而言之：${ WUPair.first.details }</td>
				</tr>
				</table>		
			</jstl:forEach>
	</div></div>
	<div class="push"></div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
