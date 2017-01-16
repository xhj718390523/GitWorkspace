<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--  导入 jquery 以及register.js --%>
<script type="text/javascript"  src ="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src = "js/register.js"></script>

<title>Insert title here</title>
</head>
<body>
<h3>欢迎注册</h3>
<% if((request.getAttribute("message")) == "exist") {%>
  <h3>用户存在</h3>
<%} %>
<% if((request.getAttribute("message")) == "null") { %>
   <h3>用户名 或者 密码不能为空</h3>
<%} %>
<form action="Register" method="post">
  姓　名：<input type="text" name = "name" id = "name"><br><br>
  密　码：<input type="password" name = "password"  id = "password"><br><br>
    <input type="submit" value = "注册">　
  <input type="reset"  value = "取消">
</form><br><br>
<a href="login.jsp">愉快的去登录---></a>
</body>
</html>