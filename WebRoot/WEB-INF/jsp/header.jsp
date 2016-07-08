<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<header>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
<!-- 				<button type="button" class="navbar-toggle collapsed" -->
<!-- 					data-toggle="collapse" data-target="#navbar" aria-expanded="false" -->
<!-- 					aria-controls="navbar"> -->
<!-- 					<span class="sr-only">Toggle navigation</span> -->
<!-- 					<span class="icon-bar"></span> -->
<!-- 					<span class="icon-bar"></span> -->
<!-- 					<span class="icon-bar"></span> -->
<!-- 				</button> -->
				<a class="navbar-brand" href="um">某大型房屋交易中心</a>
				<a class="navbar-brand" href="searchHouse!initHouse?newstype=0">我要租房</a> 
				<a class="navbar-brand" href="searchHouse!initHouse?newstype=1">我要买房</a> 
				<a class="navbar-brand" href="ToPubnews">发布房源</a> 
				<a class="navbar-brand" href="pubnews">房友论坛</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<form class="navbar-form navbar-right" id="loginform" method="post"
					action="um!login"
					style="display:<%=session.getAttribute("user") != null ? "none" : "block"%>">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control"
							id="useremail" onblur="checkmail();" name="users.email">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control"
							name="users.password">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
					<!-- 					<button class="btn btn-danger" type="button" -->
					<!-- 						onclick="location='regedit.jsp'">Sign up</button> -->
					<a class="btn btn-danger" href="regedit">Sign up</a>
				</form>
				<form class="navbar-form navbar-right" id="loginform" method="post"
					action="um!loginout"
					style="display:<%=session.getAttribute("user") != null ? "block" : "none"%>">
					<div class="form-group">
						<p>
							<font style="color:#40e0d0">欢迎您&nbsp&nbsp<a
								href="ToSpace!loadPageInfo">${sessionScope.user.nickName}</a></font>&nbsp&nbsp
						</p>
					</div>
					<button type="submit" class="btn btn-success">Sign out</button>
				</form>
			</div>
		</div>
	</nav>
</header>
<hr>