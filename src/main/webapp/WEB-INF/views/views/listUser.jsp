<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<article id="content" class="module width_3_quarter">
	<header>
		<h3 class="tabs_involved">微信用户</h3>
		<ul class="tabs">
			<li><a href="#tab1">微信用户</a></li>
		</ul>
	</header>

	<div class="tab_container">
		<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="0">
				<thead>
					<tr>
						<th>用户</th>
						<th>性别</th>
						<th>剩余抽奖次数</th>
						<th>国家</th>
						<th>省份</th>
						<th>城市</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userlist}" var="user">

						<tr>
							<td>${user.nickname}</td>
							<td>
							<c:if test="${user.sex == 1}">
								男
							</c:if>
							<c:if test="${user.sex == 2}">
								女
							</c:if>
							</td>
							<td>${user.lotterynumber}</td>
							<td>${user.country}</td>
							<td>${user.province}</td>
							<td>${user.city}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- end of #tab1 -->
	</div>
	<!-- end of .tab_container -->

</article>
<!-- end of content manager article -->