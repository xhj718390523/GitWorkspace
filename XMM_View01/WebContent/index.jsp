<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入jquery -->
<script type="text/javascript"  src="js/jquery-3.1.1.js"></script>
<script type="text/javascript"  src="js/test.js"></script>
<title>Insert title here</title>
</head>
<style>
div{
  width: 600px;
  height: 400px;
 
  float: left;
  display: inline;
  margin-left: 40px;
  margin-top: 40px;
}
#div02{
 border: solid 1px;;
}
li{
   list-style-type: none;
}
</style>
<body>
<% if((session.getAttribute("islogin")) != "success") 
  response.sendRedirect("login.jsp");
%>

<div id = "div01">


<form action="TranXML" method="post">
 <textarea rows="26" cols="150" name = "text"></textarea><br>
 <input type="submit" value="导入xml">
 </form>

 
 </div>
</body>
</html>











