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
										style="width: 100%;height:360px;"
									    src=" ${homepage[0].picadd}"
										data-holder-rendered="true">
										<div class="carousel-caption">
								        <a href="zs?newsId=${homepage[0].houseNewsId}">
								        <h2 style="color:#fff;">${homepage[0].remarks}</h2>
								      </a>
								      </div>
								</div>
								<div class="item" style="background-size:cover;">
									<img
										style="width: 100%;height:360px;"
										src="${homepage[1].picadd}"
										data-holder-rendered="true">
										<div class="carousel-caption">
								        <a href="zs?newsId=${homepage[1].houseNewsId}">
								        <h2 style="color:#fff;">${homepage[1].remarks}</h2>
								      </a>
								      </div>
								</div>
								<div class="item" style="background-size:cover;">
									<img
									    style="width: 100%;height:360px;"
										src="${homepage[2].picadd}"
										data-holder-rendered="true">
										<div class="carousel-caption">
								        <a href="zs?newsId=${homepage[2].houseNewsId}">
								        <h2 style="color:#fff;">${homepage[2].remarks}</h2>
								      </a>
								      </div>
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
						<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#renttab" data-toggle="tab">租房信息查询</a></li>
						<li><a href="#soldtab" data-toggle="tab">售房信息查询</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="renttab">
						<form action="searchHouse!findHouse" method="post">
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group">
										<label>房屋地区</label> <select class="form-control" name="region">
											<option value="0">不限</option>
											<option value="1">洪山区</option>
											<option value="2">武昌区</option>
											<option value="3">江岸区</option>
											<option value="4">东湖高新区</option>
											<option value="5">江汉区</option>
											<option value="6">汉阳区</option>
											<option value="7">硚口区</option>
											<option value="8">东西湖区</option>
											<option value="9">青山区</option>
											<option value="10">黄陂区</option>
											<option value="11">沌口区</option>
											<option value="12">江夏区</option>
											<option value="13">蔡甸区</option>
											<option value="14">汉南区</option>
											<option value="15">新洲区</option>
										</select>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<label>房屋楼层</label> <select class="form-control" name="floor">
											<option value="0">不限</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13楼以上</option>
										</select>
									</div>
								</div>

								<div class="col-lg-12">
									<div class="form-group">
										<label>面积区间(m&sup2;)</label> <select class="form-control"
											name="area">
											<option value="0">不限</option>
											<option value="1">30 - 40</option>
											<option value="2">40 - 60</option>
											<option value="3">60 - 80</option>
											<option value="4">80 - 100</option>
											<option value="5">100 - 120</option>
											<option value="6">120 - 150</option>
											<option value="7">150以上</option>
										</select>
									</div>
								</div>
								<input type="hidden" value="0" name="price" /> <input
									type="hidden" value="0" name="sorting" /><input type="hidden"  name="newstype"  value="0"/>
								<div class="col-lg-12" style="margin-top:25px">
									<button type="submit" class="btn btn-danger col-lg-6 col-lg-offset-3" 
										name="SubmitChooseHouse">搜索</button>
								</div>
							</div>
						</form>
						</div><!-- end of rent tab -->
						<div class="tab-pane fade" id="soldtab">
						<form action="searchHouse!findHouse" method="post">
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group">
										<label>房屋地区</label> <select class="form-control" name="region">
											<option value="0">不限</option>
											<option value="1">洪山区</option>
											<option value="2">武昌区</option>
											<option value="3">江岸区</option>
											<option value="4">东湖高新区</option>
											<option value="5">江汉区</option>
											<option value="6">汉阳区</option>
											<option value="7">硚口区</option>
											<option value="8">东西湖区</option>
											<option value="9">青山区</option>
											<option value="10">黄陂区</option>
											<option value="11">沌口区</option>
											<option value="12">江夏区</option>
											<option value="13">蔡甸区</option>
											<option value="14">汉南区</option>
											<option value="15">新洲区</option>
										</select>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group">
										<label>房屋楼层</label> <select class="form-control" name="floor">
											<option value="0">不限</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13楼以上</option>
										</select>
									</div>
								</div>

								<div class="col-lg-12">
									<div class="form-group">
										<label>面积区间(m&sup2;)</label> <select class="form-control"
											name="area">
											<option value="0">不限</option>
											<option value="1">30 - 40</option>
											<option value="2">40 - 60</option>
											<option value="3">60 - 80</option>
											<option value="4">80 - 100</option>
											<option value="5">100 - 120</option>
											<option value="6">120 - 150</option>
											<option value="7">150以上</option>
										</select>
									</div>
								</div>
								
								<input type="hidden" value="0" name="price" /> <input
									type="hidden" value="0" name="sorting" /><input type="hidden"  name="newstype"  value="1"/>
								<div class="col-lg-12 " style="margin-top:25px ;" >
									<button type="submit" class="btn btn-warning col-lg-6 col-lg-offset-3" 
										name="SubmitChooseHouse">搜索</button>
								</div>
							</div>
						</form>
						</div><!-- end of sold tab -->
						</div>
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
							<a href="zs?newsId=${homepage[3].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[3].picadd}" class="img-responsive">
								<label>${homepage[3].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[4].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[4].picadd}" class="img-responsive">
								<label>${homepage[4].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[5].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[5].picadd}" class="img-responsive">
								<label>${homepage[5].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[6].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[6].picadd}" class="img-responsive">
								<label>${homepage[6].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[7].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[7].picadd}" class="img-responsive">
								<label>${homepage[7].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[8].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[8].picadd}" class="img-responsive">
								<label>${homepage[8].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[9].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[9].picadd}" class="img-responsive">
								<label>${homepage[9].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[10].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[10].picadd}" class="img-responsive">
								<label>${homepage[10].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[11].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[11].picadd}" class="img-responsive">
						        <label>${homepage[11].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[12].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[12].picadd}" class="img-responsive">
								<label>${homepage[12].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[13].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[13].picadd}" class="img-responsive">
								<label>${homepage[13].remarks}</label>
							</a>
						</div>
						<div class="col-xs-3">
							<a href="zs?newsId=${homepage[14].houseNewsId}" class="thumbnail" onclick="go_js(${user});"> <img
								src="${homepage[14].picadd}" class="img-responsive">
								<label>${homepage[14].remarks}</label>
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

