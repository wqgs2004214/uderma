<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<article id="content" class="module width_3_quarter">
	<header>
		<h3 class="tabs_involved">中奖用户</h3>
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
								<td><fmt:formatDate value="${prize.winningTime}"
										pattern="yyyy-MM-dd HH:mm" /></td>
								<td><input type="image"
									src="<c:url value="/resources/images/icn_edit.png" />"
									title="Edit"><input type="image"
									src="<c:url value="/resources/images/icn_trash.png" />"
									title="Trash"></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- end of #tab1 -->

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
								<td><fmt:formatDate value="${prize.winningTime}"
										pattern="yyyy-MM-dd:HH:mm" /></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<!-- end of #tab2 -->
	</div>
	<!-- end of .tab_container -->

</article>
<!-- end of content manager article -->