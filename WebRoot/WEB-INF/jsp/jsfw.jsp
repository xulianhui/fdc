<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>房屋信息介绍</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/buttons.css" />
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="wrapper">
	<div class="container" style="height: auto;">
		<div class="row">
			<div class="col-lg-12" style="height: 300px;">
				<div class="col-lg-4">
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="${housenews.img1 }" class="img-auto">
								<div class="carousel-caption"></div>
							</div>
							<div class="item">
								<img src="${housenews.img2 }" class="img-auto">
								<div class="carousel-caption"></div>
							</div>

							<div class="item">
								<img src="${housenews.img3 }" class="img-auto">
								<div class="carousel-caption"></div>
							</div>
						</div>

						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" role="button" data-slide="next">
							<span class="glyphicon glyphicon-chevron-right"
							aria-hidden="true"></span> <span class="sr-only">Next</span>
						</a>
					</div>
				</div>

				<div class="col-lg-8">
					<table class="table table-bordered ">
						<tr>
							<td>详细地址</td>
							<td>${housenews.houseAddDetail }</td>
						</tr>
						<tr>
							<td>楼层</td>
							<td>${housenews.houseFloor }</td>
						</tr>
						<tr>
							<td>价格</td>
							<td>${housenews.housePrice }</td>
						</tr>
						<tr>
							<td>住房面积</td>
							<td>${housenews.houseArea }</td>
						</tr>
					</table>
					
					<a class="btn btn-default" href="lx?toId=${housenews.userId }">联系卖家</a>
					<a class="btn btn-default" href="collect?houseNewsId=${housenews.id }">收藏</a>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a href="#xxxx"
					aria-controls="xxxx" role="tab" data-toggle="tab">详细信息</a></li>
				<li role="presentation">
					<!--<a href="#">用户评论</a>--> <a href="#ykpl" aria-controls="yhpl"
					role="tab" data-toggle="tab">用户评论</a>
				</li>
			</ul>
			<div class="tab-content col-lg-10" >
				<div role="tabpanel" class="tab-pane active" id="xxxx">
					<div class="row"  >
						<ul class="list-group" >
							<li class="list-group-item" style="background-color:transparent;">
								<h3>基本信息</h3>
								<div class="row" align="center">
									<p class="col-lg-3">
										客厅个数：<span>${housenews.houseHall }</span>
									</p>
									<p class="col-lg-3">
										卫生间数：<span>${housenews.houseWc }</span>
									</p>
									<p class="col-lg-3">
										房间个数：<span>${housenews.houseRoom }</span>
									</p>
									<p class="col-lg-3">
										房屋面积：<span>${housenews.houseArea}</span>
									</p>
									<p class="col-lg-3">
										建筑类型：<span>${housenews.buildType }</span>
									</p>
									<p class="col-lg-3">
										联系电话：<span>${housenews.tel }</span>
									</p>
								</div>
							</li>
							<li class="list-group-item" style="background-color:transparent;">
								<h3>房源特色</h3>
								<div class="row">
									<p>${housenews.houseDetail }</p>
								</div>
							</li>
							<li class="list-group-item" style="background-color:transparent;">
								<h3>房源照片</h3>
								<div class="row" align="center">
									<img src="${housenews.img4 }" class="img-auto">
									<hr>
									<img src="${housenews.img5 }" class="img-auto">
									<hr>
									<img src="${housenews.img6 }" class="img-auto">
								</div>
							</li>
						</ul>
					</div>
				</div>

				<div role="tabpanel" class="tab-pane" id="ykpl">

					<hr />
					<c:forEach var="pair" items="${list}">
						<div class="media">
							<div class="media-left">
								<a href="#"> <img class="media-object img-circle"
									src="${pair.second.headImg }"
									style="width: 64px; height: 64px;">
								</a>
							</div>
							<div class="media-body">
								<h4 class="media-heading">${pair.second.nickName}</h4>
								${pair.first.content}
								<div class="cmt-info">
									<span style="padding: 0 10px;">${pair.first.conTime}</span>
								</div>
							</div>
						</div>
						<hr />
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>















