<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>欢迎来到汉王</h3>
<%-- 消息提醒 --%>
  <% if((request.getAttribute("logmessage")) == "null") {%>
   <h3>用户名或者密码不能为空</h3>
  <%} %>
  
  <% if((request.getAttribute("logmessage")) == "nameError") {%>
   <h3>用户不存在</h3>
  <%} %>
  
  <% if((request.getAttribute("logmessage")) == "passwordError") {%>
   <h3>密码错误</h3>
  <%} %>
 
<form  action="Login"  method="post">
   用户名：<input type="text" name = "name" ><br><br>
   密　码：<input  type="password"  name = "password"><br><br>
   <input type = "submit" value = "登录">
    
</form><br><br>
<a  href="register.jsp">注册有惊喜---></a>
</body>
</html>