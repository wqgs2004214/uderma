<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:if test="${!ajaxRequest}">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>后台登录</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />" />
		<script src="<c:url value="/resources/js/cufon-yui.js" />" type="text/javascript"></script>
		<script src="<c:url value="/resources/js/ChunkFive_400.font.js" />" type="text/javascript"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.5.2.min.js" />"></script>
    </head>
    <body>
</c:if>
		<div id="formsContent" class="wrapper">
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
				<form:form id="login" method="post" modelAttribute="userBean" cssClass="login active">
						<h3>登录</h3>
						<div>
							<form:label path="name">
		  					用户名:
		 					</form:label>
		 					<form:input path="name" />
							<form:errors path="name" cssClass="error" />
							
						</div>
						<div>
							<form:label path="password">
		  					密码:
		 					</form:label>
		 					<form:password path="password" />
							<form:errors path="password" cssClass="error" />
							
						</div>
						<div class="bottom">
							<div class="remember">
								<%-- <input type="checkbox" /><span>记住密码</span> --%>
							</div>
							<button type="submit">登录</button>
							<!-- <input type="submit" value="登录"></input> -->
							<div class="clear"></div>
						</div>
				</form:form>
				<script type="text/javascript">
						/* $(document).ready(function() {
							$("#login").submit(function() {
								$.post($(this).attr("action"), $(this).serialize(), function(html) {
									$("#formsContent").replaceWith(html);
									$('html, body').animate({ scrollTop: $("#form_wrapper").offset().top }, 500);
								});
								return false;  
							});			
						}); */
				</script>
					
				</div>
				<div class="clear"></div>
			</div>
		</div>
		
<c:if test="${!ajaxRequest}">	
    </body>
</html>
</c:if>