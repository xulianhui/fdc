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
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
<script type="text/javascript">
var a="||";
var b="||";
function nnn() {
	a=a+b;
}
</script>
<title></title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->
	<div class="wrapper">
		<div class="container">
			<h1>${regedit_state}</h1>
			<!--your content-->
			<div class="ss"></div>
			<div class="cc"></div>
			<div ></div>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>