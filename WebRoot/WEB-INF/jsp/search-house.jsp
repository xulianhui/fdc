<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		
		<title>search house</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
				<link rel="stylesheet" type="text/css" href="styles.css">
				-->
		
		<link href="css/bootstrap.css" rel="stylesheet" />
		<link href="css/pagediv.css" rel="stylesheet"/>
		<link href="css/main.css" rel="stylesheet" />
		<script type="text/javascript" src="js/pagediv.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		
		<link rel="stylesheet" href="css/mystyles.css" />
		<script src="js/main.js"></script>
		<!-- 翻页  -->
		<style type="text/css">
			.list-group .list-group-item {
				background-color: transparent;
			}
		</style>
			
	</head>
	
	<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrapper">
		<div class="container">
			<form action="searchHouse!findHouse" method="post">
				<div class="row">
					<div class="col-lg-2">
						<div class="form-group">
							<label>房屋地区</label> <select class="form-control" name="region">
								<option value="0"
									<jstl:if test="${region=='0'}">selected="true"</jstl:if>>不限</option>
								<option value="1"
									<jstl:if test="${region=='1'}">selected="true"</jstl:if>>洪山区</option>
								<option value="2"
									<jstl:if test="${region=='2'}">selected="true"</jstl:if>>武昌区</option>
								<option value="3"
									<jstl:if test="${region=='3'}">selected="true"</jstl:if>>江岸区</option>
								<option value="4"
									<jstl:if test="${region=='4'}">selected="true"</jstl:if>>东湖高新区</option>
								<option value="5"
									<jstl:if test="${region=='5'}">selected="true"</jstl:if>>江汉区</option>
								<option value="6"
									<jstl:if test="${region=='6'}">selected="true"</jstl:if>>汉阳区</option>
								<option value="7"
									<jstl:if test="${region=='7'}">selected="true"</jstl:if>>硚口区</option>
								<option value="8"
									<jstl:if test="${region=='8'}">selected="true"</jstl:if>>东西湖区</option>
								<option value="9"
									<jstl:if test="${region=='9'}">selected="true"</jstl:if>>青山区</option>
								<option value="10"
									<jstl:if test="${region=='10'}">selected="true"</jstl:if>>黄陂区</option>
								<option value="11"
									<jstl:if test="${region=='11'}">selected="true"</jstl:if>>沌口区</option>
								<option value="12"
									<jstl:if test="${region=='12'}">selected="true"</jstl:if>>江夏区</option>
								<option value="13"
									<jstl:if test="${region=='13'}">selected="true"</jstl:if>>蔡甸区</option>
								<option value="14"
									<jstl:if test="${region=='14'}">selected="true"</jstl:if>>汉南区</option>
								<option value="15"
									<jstl:if test="${region=='15'}">selected="true"</jstl:if>>新洲区</option>
							</select>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="form-group">
							<label>房屋楼层</label> <select class="form-control" name="floor">
								<option value="0"
									<jstl:if test="${floor=='0'}">selected="true"</jstl:if>>不限</option>
								<option value="1"
									<jstl:if test="${floor=='1'}">selected="true"</jstl:if>>1</option>
								<option value="2"
									<jstl:if test="${floor=='2'}">selected="true"</jstl:if>>2</option>
								<option value="3"
									<jstl:if test="${floor=='3'}">selected="true"</jstl:if>>3</option>
								<option value="4"
									<jstl:if test="${floor=='4'}">selected="true"</jstl:if>>4</option>
								<option value="5"
									<jstl:if test="${floor=='5'}">selected="true"</jstl:if>>5</option>
								<option value="6"
									<jstl:if test="${floor=='6'}">selected="true"</jstl:if>>6</option>
								<option value="7"
									<jstl:if test="${floor=='7'}">selected="true"</jstl:if>>7</option>
								<option value="8"
									<jstl:if test="${floor=='8'}">selected="true"</jstl:if>>8</option>
								<option value="9"
									<jstl:if test="${floor=='9'}">selected="true"</jstl:if>>9</option>
								<option value="10"
									<jstl:if test="${floor=='10'}">selected="true"</jstl:if>>10</option>
								<option value="11"
									<jstl:if test="${floor=='11'}">selected="true"</jstl:if>>11</option>
								<option value="12"
									<jstl:if test="${floor=='12'}">selected="true"</jstl:if>>12</option>
								<option value="13"
									<jstl:if test="${floor=='13'}">selected="true"</jstl:if>>13楼以上</option>
							</select>
						</div>
					</div>
					
					<div class="col-lg-2">
						<div class="form-group">
							<label>面积区间(m&sup2;)</label> <select class="form-control" name="area">
							<option value="0"
									<jstl:if test="${area=='0'}">selected="true"</jstl:if>>不限</option>
								<option value="1"
									<jstl:if test="${area=='1'}">selected="true"</jstl:if>>30 - 40</option>
								<option value="2"
									<jstl:if test="${area=='2'}">selected="true"</jstl:if>>40 - 60</option>
								<option value="3"
									<jstl:if test="${area=='3'}">selected="true"</jstl:if>>60 - 80</option>
								<option value="4"
									<jstl:if test="${area=='4'}">selected="true"</jstl:if>>80 - 100</option>
								<option value="5"
									<jstl:if test="${area=='5'}">selected="true"</jstl:if>>100 - 120</option>
								<option value="6"
									<jstl:if test="${area=='6'}">selected="true"</jstl:if>>120 - 150</option>
								<option value="7"
									<jstl:if test="${area=='7'}">selected="true"</jstl:if>>150以上</option>
							</select>
						</div>
					</div>
					
					<div class="col-lg-2">
						<div class="form-group">
							<label>价格区间(${priceunit})</label> <select class="form-control" name="price">
								<option value="0"
									<jstl:if test="${price=='0'}">selected="true"</jstl:if>>${priceinterval[0]}</option>
								<option value="1"
									<jstl:if test="${price=='1'}">selected="true"</jstl:if>>${priceinterval[1]}</option>
								<option value="2"
									<jstl:if test="${price=='2'}">selected="true"</jstl:if>>${priceinterval[2]}</option>
								<option value="3"
									<jstl:if test="${price=='3'}">selected="true"</jstl:if>>${priceinterval[3]}</option>
								<option value="4"
									<jstl:if test="${price=='4'}">selected="true"</jstl:if>>${priceinterval[4]}</option>
								<option value="5"
									<jstl:if test="${price=='5'}">selected="true"</jstl:if>>${priceinterval[5]}</option>
								<option value="6"
									<jstl:if test="${price=='6'}">selected="true"</jstl:if>>${priceinterval[6]}</option>
							</select>
						</div>
					</div>
					
					<div class="col-lg-2">
						<div class="form-group">
							<label>排序</label> <select class="form-control" name="sorting">
								<option value="0"
									<jstl:if test="${sorting=='0'}">selected="true"</jstl:if>>不限</option>
								<option value="1"
									<jstl:if test="${sorting=='1'}">selected="true"</jstl:if>>价格升序</option>
									<option value="2"
									<jstl:if test="${sorting=='2'}">selected="true"</jstl:if>>价格降序</option>
							</select>
						</div>
					</div>
					<div class="col-lg-2" style="margin-top:25px">
						<button type="submit" class="btn btn-default"
							name="SubmitChooseHouse">Submit</button>
					</div>
				</div>
			</form>
	
	
			<div class="row list-group">
				<p style="font-family:微软雅黑">${message }</p>
				<jstl:forEach var="FindHouse" items="${houseList }">
					<div class="row list-group-item">
						<div class="col-lg-3 house-img">
							<a href="zs?newsId=${FindHouse.id }"> <img src="${ FindHouse.img1 }" alt="no picture!"
								class="img-rounded"/></a>
						</div>
						<div class="col-lg-9 house-info-table">
							<table class="table table-bordered house-info">
								<tr>
									<td style="width:15%">地址</td>
									<td>${FindHouse.houseReg }${FindHouse.houseAddDetail }</td>
								</tr>
								<tr>
									<td>楼层</td>
									<td>${FindHouse.houseFloor }</td>
								</tr>
								<tr>
									<td>价格</td>
									<td>${FindHouse.housePrice }元</td>
								</tr>
								<tr>
									<td>住房面积</td>
									<td>${FindHouse.houseArea }平米</td>
								</tr>
								<tr>
									<td>房屋描述</td>
									<td>${FindHouse.houseDetail }</td>
								</tr>
							</table>
						</div>
					</div>
				</jstl:forEach>
			</div>
	
			<div style="height:60px">
				<div id="div_pager"></div>
			</div>
			
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
				
		<script type="text/javascript">
			var totalPage = ${totalpage};
			var totalRecords = ${list.size()};
			var pageNo = getParameter('p'); //这里设置参数名(柯 乐 义 注 释)
			if (!pageNo) {
				pageNo = 1;
			}
			//生成分页控件 根据分页的形式在这里设置
			kkpager.init({
				pno : pageNo,
				//总页码
				total : totalPage,
				//总数据条数
				totalRecords : totalRecords,
				//链接前部
				hrefFormer : 'searchHouse!paging',
				//链接尾部
				hrefLatter : '',
				getLink : function(n) {
					return this.hrefFormer + this.hrefLatter + "?p=" + n; //参数名跟上面相同
				}
			});
			kkpager.generPageHtml();
		</script>
	</body>
</html>
