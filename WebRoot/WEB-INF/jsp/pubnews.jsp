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
<script src="js/myjs.js"></script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>

<title></title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
 	<%/* if(session.getAttribute("user")==null) response.sendRedirect("pubresult");*/%> 
	<!--header end here-->
	<div class="wrapper">
		<div class="container">
			<form class="col-md-6 col-md-offset-3" action="<%=basePath %>addnew" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">房源标题</label>
						</div>
						<div class="col-lg-10">
							<input type="text" class="form-control"
								name="housenews.houseTitle" id="houseTitle" placeholder="房源标题" required="required"
								onblur="checkform()" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">租售状态</label>
						</div>
						<div class="col-lg-4">
							<select name="housenews.newsType" class="form-control">
								<option value="0">出租</option>
								<option value="1">出售</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">建筑类型</label>
						</div>
						<div class="col-lg-6">
							<select name="housenews.buildType" class="form-control">
								<option value="0">商品房</option>
								<option value="1">。。。</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-4">
							<label>房屋区域</label>
						</div>
						<div class="col-lg-8">
							<label>详细地址</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<select name="housenews.houseReg" class="form-control">
								<option value="洪山区">洪山区</option>
								<option value="武昌区">武昌区</option>
								<option value="江夏区">江夏区</option>
								<option value="青山区">青山区</option>
								<option value="其他">其他</option>
							</select>
						</div>
						<div class="col-lg-8">
							<input class="form-control" type="text"
								name="housenews.houseAddDetail" id="houseAddDetail" required="required"
								placeholder="详细地址" onblur="checkform()">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-6">
							<label for="">房屋楼层</label>
						</div>
						<div class="col-lg-6">
							<label for="">住房面积</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<input class="form-control" type="text" onkeypress="keyPress()"
								name="housenews.houseFloor" id="houseFloor" placeholder="房屋楼层"
								onblur="checkform()">
						</div>
						<div class="col-lg-6">
							<input class="form-control" type="text" onkeypress="keyPress()"
								name="housenews.houseArea" id="houseArea" placeholder="住房面积"
								onblur="checkform()">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">户型：</label>
						</div>
						<div class="col-lg-2">
							<input class="form-control" type="text" onkeypress="keyPress()" required="required"
								name="housenews.houseRoom" id="houseRoom" placeholder="" />
						</div>
						<div class="col-lg-1">
							<label for="">室</label>
						</div>
						<div class="col-lg-2">
							<input class="form-control" type="text" onkeypress="keyPress()"
								onblur="checkform()" name="housenews.houseHall" id="houseHall" required="required"
								placeholder="" />
						</div>
						<div class="col-lg-1">
							<label for="">厅</label>
						</div>
						<div class="col-lg-2">
							<input class="form-control" type="text" name="housenews.houseWc" required="required"
								id="hosueWc" onblur="checkform()" onfocus="keyPress()"
								placeholder="" />
						</div>
						
						<div class="col-lg-1">
							<label for="">卫</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-4">
							<label for="">住房价格</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<input class="form-control" type="text" onkeypress="keyPress()" required="required"
								onblur="checkform()" name="housenews.housePrice" id="housePrice"
								placeholder="住房价格">
						</div>
						<div class="col-lg-2">
							<P>元/天</P>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-6">
							<label for="">联系电话</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<input class="form-control" type="text" name="housenews.tel" required="required"
								id="tel"  onblur="checkform()" placeholder="联系电话">
						</div>
					</div>
				</div>

				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">房源照片(最多六张)</label>
						</div>
					</div>
					<div calss="row" id="pic1" >
						<img alt="" src=""  id="img1" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image1" onchange="change('img1','image1');showdiv()">
						</div>
					</div>
					<div calss="row" id="pic2"  style="display: none;">
						<img alt="" src=""  id="img2" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image2"  onchange="change('img2','image2');showdiv()">
						</div>
					</div>
					<div calss="row" id="pic3" style="display: none;">
						<img alt="" src=""  id="img3" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image3"  onchange="change('img3','image3');showdiv()">
						</div>
					</div>
					<div calss="row" id="pic4" style="display: none;">
						<img alt="" src=""  id="img4" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image4"  onchange="change('img4','image4');showdiv()">
						</div>
					</div>
					<div calss="row" id="pic5" style="display: none;">
						<img alt="" src=""  id="img5" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image5" onchange="change('img5','image5');showdiv()" >
						</div>
					</div>
					<div calss="row" id="pic6" style="display: none;">
						<img alt="" src=""  id="img6" style="width:100%;height:100%"/>
						<div class="col-lg-10">
							<input type="file" name="image" id="image6"  onchange="change('img6','image6');showdiv()">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="row">
						<div class="col-lg-2">
							<label for="">细节描述</label>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<textarea name="housenews.houseDetail" class="form-control"
								rows="3">
							</textarea>
						</div>
					</div>
				</div>
				<input type="hidden" name="housenews.houseNewsStatus" value="0">
				<div class="form-group">
					<div class="row">
						<div class="col-lg-6 col-lg-offset-3">
							<div class="col-lg-6 pull-left">
								<input type="submit" class="btn btn-default" value="提交" >
							</div>
							<div class="col-lg-6 pull-right">
								<input type="reset" class="btn btn-default" value="重置" >
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>