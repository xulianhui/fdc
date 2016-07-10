<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'wanted.jsp' starting page</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/myjs.js"></script>
<link rel="stylesheet" href="css/mystyles.css" />
<script src="js/main.js"></script>

</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
	<div class="container">
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#renttab" data-toggle="tab">求租信息发布</a></li>
			<li><a href="#soldtab" data-toggle="tab">求售信息发布</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="renttab">
				<form id="tab0" class="col-lg-10  form-horizontal" id="rent" method="post" action="pubWanted">
					<div class="form-group">
						<div class="col-lg-8">
							<label>用户</label>
							<label>${user.nickName}(id:${user.id})</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>状态</label>
							<label>求租</label> <input type="hidden" name="wanted.wantedType" value="false" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>面积</label>
							<input type="text"  name="wanted.minArea"  required="required" />
							<label>----</label>
							<input type="text" name="wanted.maxArea"  required="required" />
							<label>平米</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>价格</label>
							<input type="text" required="required" name="wanted.maxPrice" />
							<label>元/平米</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>联系电话</label>		
							<input type="text" required="required" name="wanted.userTel"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>详细需求</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-12">
							<textarea class="col-lg-12" rows="8" required="required" name="wanted.details"></textarea>
						</div>
					</div>
					<div class="form-group text-center">
						<div class="col-lg-2 col-lg-offset-4">
							<input  type="reset" class="btn-warning btn-sm" value="重置" />
						</div>
						<div class="col-lg-2">
							<input  type="submit"  class="btn-info btn-sm" value="发布" />
						</div>
					</div>
				</form>
				<!-- end of 求租-->
			</div>
			<div class="tab-pane fade" id="soldtab">
				<!--
            	作者：1565063012@qq.com
            	时间：2016-07-05
            	描述：求售表单
            -->
				<form  method="post"  id="tab0" class="col-lg-10  form-horizontal" id="sold" method="post" action="pubWanted">
					<div class="form-group">
						<div class="col-lg-8">
							<label>用户</label>
							<label>${user.nickName}(id:${user.id})</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>状态</label>
							<label>求售</label> <input type="hidden" name="wanted.wantedType" value="true" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>面积</label>
							<input type="text"  name="wanted.minArea"  required="required" />
							<label>----</label>
							<input type="text" name="wanted.maxArea"  required="required" />
							<label>平米</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>价格</label>
							<input type="text" required="required"  name="wanted.maxPrice"/>
							<label>元/平米</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>联系电话</label>		
							<input type="text" required="required" name="wanted.userTel"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-8">
							<label>详细需求</label>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-12">
							<textarea class="col-lg-12" rows="8" required="required" name="wanted.details"></textarea>
						</div>
					</div>
					<div class="form-group text-center">
						<div class="col-lg-2 col-lg-offset-4">
							<input  type="reset"  class="btn-warning btn-sm" value="重置" />
						</div>
						<div class="col-lg-2">
							<input  type="submit"  class="btn-info btn-sm" value="发布" />
						</div>
					</div>
				</form>
				<!--
            	作者：1565063012@qq.com
            	时间：2016-07-05
            	描述：end of 求售
            -->
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
