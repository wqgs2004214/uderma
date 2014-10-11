<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>

<head>
	<meta charset="utf-8"/>
	<title>优德医美后台管理系统</title>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/layout.css" />" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="<c:url value="/resources/js/jquery-1.5.2.min.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/hideshow.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.tablesorter.min.js" />" type="text/javascript"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.equalHeight.js" />"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});
	
	$("#viewUser").click(function() {
		$.post("<c:url value="/viewUser" />", $(this).serialize(), function(html) {
			$("#content").replaceWith(html);
			$(".tab_content").hide(); //Hide all content
			$("ul.tabs li:first").addClass("active").show(); //Activate first tab
			$(".tab_content:first").show(); //Show first tab content
			$("#content").fadeIn("slow");
			//$('html, body').animate({ scrollTop: 0 }, 500);
		});
		return false;  
				
	});
	
	$("#prizeUser").click(function() {
		$.post("<c:url value="/prizeUser" />", $(this).serialize(), function(html) {
			$("#content").replaceWith(html);
			$(".tab_content").hide(); //Hide all content
			$("ul.tabs li:first").addClass("active").show(); //Activate first tab
			$(".tab_content:first").show(); //Show first tab content
			$("#content").fadeIn("slow");
			$("ul.tabs li").click(function() {

				$("ul.tabs li").removeClass("active"); //Remove any "active" class
				$(this).addClass("active"); //Add "active" class to selected tab
				$(".tab_content").hide(); //Hide all tab content

				var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
				$(activeTab).fadeIn(); //Fade in the active ID content
				return false;
			});
		});
		return false;  
				
	});
	
	

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html">控制台</a></h1>
			<!-- 
				<h2 class="section_title">Dashboard</h2><div class="btn_view_site"><a href="http://www.medialoot.com">View Site</a></div> 
			-->
		</hgroup>
	</header>
	
	<section id="secondary_bar">
		<div class="user">
			<p>管理员admin</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
		<div class="breadcrumbs_container">
			<article class="breadcrumbs"><a href="#">控制台</a> <div class="breadcrumb_divider"></div> <a class="current">微信用户统计</a></article>
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<form class="quick_search">
			<input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
		</form>
		<hr/>
		<!-- 
		<h3>Content</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="#">New Article</a></li>
			<li class="icn_edit_article"><a href="#">Edit Articles</a></li>
			<li class="icn_categories"><a href="#">Categories</a></li>
			<li class="icn_tags"><a href="#">Tags</a></li>
		</ul>
		<h3>Users</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="#">Add New User</a></li>
			<li class="icn_view_users"><a href="#">View Users</a></li>
			<li class="icn_profile"><a href="#">Your Profile</a></li>
		</ul>
		<h3>Media</h3>
		<ul class="toggle">
			<li class="icn_folder"><a href="#">File Manager</a></li>
			<li class="icn_photo"><a href="#">Gallery</a></li>
			<li class="icn_audio"><a href="#">Audio</a></li>
			<li class="icn_video"><a href="#">Video</a></li>
		</ul>
		 -->
		<h3>管理</h3>
		<ul class="toggle">
			<li class="icn_view_users"><a id="viewUser" href="#">查看微信用户</a></li>
			<li class="icn_security"><a id="prizeUser" href="#">中奖用户</a></li>
			<li class="icn_jump_back"><a href="<c:url value="/logout" />">退出系统</a></li>
		</ul>
		
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2014 优德医美</strong></p>
			
		</footer>
	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">欢迎进入优德医美后台管理系统</h4>
		
		<article class="module width_full">
			<header><h3>用户增加曲线图</h3></header>
			<div class="module_content">
				<article class="stats_graph">
					<img src="http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30" width="520" height="140" alt="" />
				</article>
				
				<article class="stats_overview">
					<div class="overview_today">
						<p class="overview_day">今天</p>
						<p class="overview_count">10</p>
						<p class="overview_type">参与抽奖用户</p>
					</div>
					<div class="overview_previous">
						<p class="overview_day">昨天</p>
						<p class="overview_count">20</p>
						<p class="overview_type">参与抽奖用户</p>
					</div>
				</article>
				<div class="clear"></div>
			</div>
		</article><!-- end of stats article -->
		
		<article id="content" class="module width_3_quarter">
		<header><h3 class="tabs_involved">中奖用户</h3>
		<ul class="tabs">
   			<li><a href="#tab1">未领奖</a></li>
    		<li><a href="#tab2">已领奖</a></li>
		</ul>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<thead> 
				<tr> 
   					<th></th> 
    				<th>用户</th> 
    				<th>奖品</th> 
    				<th>中奖时间</th> 
    				<th>操作</th> 
				</tr> 
			</thead> 
			<tbody>
				<c:forEach items="${prizelist}" var="prize">
					<c:if test="${prize.prizeGoodsStatus == 1}">
						<tr>
		   					<td><input type="checkbox"></td> 
		    				<td>${prize.winnerNickname}</td> 
		    				<td>${prize.prizeGoodsName}</td> 
		    				<td><fmt:formatDate value="${prize.winningTime}" pattern="yyyy-MM-dd HH:mm" /></td> 
		    				<td><input type="image" src="<c:url value="/resources/images/icn_edit.png" />" title="Edit"><input type="image" src="<c:url value="/resources/images/icn_trash.png" />" title="Trash"></td> 
						</tr> 
					</c:if>
				</c:forEach>
			</tbody> 
			</table>
			</div><!-- end of #tab1 -->
			
			<div id="tab2" class="tab_content">
			<table class="tablesorter" cellspacing="0"> 
			<thead> 
				<tr> 
   					<th>用户</th> 
    				<th>奖品</th> 
    				<th>中奖时间</th> 
				</tr> 
			</thead> 
			<tbody>
				<c:forEach items="${prizelist}" var="prize">
					<c:if test="${prize.prizeGoodsStatus == 2}">
						<tr> 
		   					<td>${prize.winnerNickname}</td> 
	    					<td>${prize.prizeGoodsName}</td> 
	    					<td><fmt:formatDate value="${prize.winningTime}" pattern="yyyy-MM-dd:HH:mm" /></td> 
						</tr>
					</c:if>
				</c:forEach>
			</tbody> 
			</table>

			</div><!-- end of #tab2 -->
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
		
		<article class="module width_quarter">
			<header><h3>发布消息</h3></header>
			<div class="message_list">
				<div class="module_content">
					
				</div>
			</div>
			<footer>
				<form class="post_message">
					<input type="text" value="Message" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
					<input type="submit" class="btn_post_message" value=""/>
				</form>
			</footer>
		</article><!-- end of messages article -->
		
		<div class="clear"></div>
		<div class="spacer"></div>
	</section>


</body>

</html>