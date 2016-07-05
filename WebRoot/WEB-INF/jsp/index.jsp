<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>

<title></title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!--header end here-->

	<div class="wrapper">
		<div class="container">
			<!-- 清除浮动 -->
			<div class="row">
				<div class="col-lg-8">
					<div class="bs-example" data-example-id="simple-carousel">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"
									class=""></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"
									class=""></li>
							</ol>
							<div class="carousel-inner" role="listbox">
								<div class="item active" style="background-size:cover;">
									<img
										data-src="holder.js/900x500/auto/#777:#555/text:First slide"
										alt="First slide [900x500]" src=" ${homepage[0].picadd}"
										data-holder-rendered="true">
								</div>
								<div class="item" style="background-size:cover;">
									<img
										data-src="holder.js/900x500/auto/#666:#444/text:Second slide"
										alt="Second slide [900x500]" src="${homepage[1].picadd}"
										data-holder-rendered="true">
								</div>
								<div class="item" style="background-size:cover;">
									<img
										data-src="holder.js/900x500/auto/#555:#333/text:Third slide"
										alt="Third slide [900x500]" src="${homepage[2].picadd}"
										data-holder-rendered="true">
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
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-4">
					<div class="container-fluid">
						<form>
							<div class="form-group">
								<label for="">地区</label> <select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="form-group">
								<label for="">房屋类型</label> <select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="form-group">
								<label for="">价格区间</label> <select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
							<div class="form-group">
								<input class="form-control input-lg" type="text"
									placeholder="楼盘名">
							</div>
							<div class="form-group">
								<input style="width:100%;font-size:20px;" type="submit" class="btn btn-default" value="提        交 &nbsp; &nbsp;  " />
							</div>
						</form>
					</div>
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
			<div class="clearfix" style="margin-bottom: 10px;"></div>
			<!-- 清除浮动 -->
			<div class="row">
				<div class="container">
					<div class="row">
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[3].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[4].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[5].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[6].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[7].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[8].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[9].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[10].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[11].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[12].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[13].picadd}"
								class="img-responsive">
							</a>
						</div>
						<div class="col-xs-3">
							<a href="#" class="thumbnail"> <img
								src="${homepage[14].picadd}"
								class="img-responsive">
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="push"></div>
		</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

