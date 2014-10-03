<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>送礼</title>
	<link href="<c:url value="/resources/script/jquery-1.7.2.min.js" />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value="/resources/script/lotteryCore.js" />" rel="stylesheet"  type="text/css" />
	<link href="<c:url value="/resources/script/scratch.js" />" rel="stylesheet"  type="text/css" />
  </head>
  
  <body>
    抽奖程序<br>
    <img alt="" src="<c:url value="/resources/images/tomcat.gif" />" />
    <a href="listUser.do">User List</a>
  </body>
</html>

http://mp.weixin.qq.com/mp/redirect?
url=https%3A%2F%2Fopen.weixin.qq.com%2Fconnect%2F
oauth2%2Fauthorize%3F
appid%3Dwx8cbf7e0e11903570%26
redirect_uri%3Dhttp%253A%252F%252Fwx.aisidi.com%252Fasdwx%252FcallBack%252Fweixin.do%253F%26response_type%3DCODE%26scope%3Dsnsapi_base%26state%3DASDSCRATCH%23wechat_redirect