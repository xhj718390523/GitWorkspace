<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% if((session.getAttribute("islogin")) != "success") 
  response.sendRedirect("login.jsp");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%--引入js 跟 css --%>
<%-- 
    
    <link rel="stylesheet" href="js/screen.css" />
--%>
    <link rel="stylesheet" href="js/jquery.treeview.css" />
	<script src="js/jquery-3.1.1.js"></script>
	<script src="js/jquery.cookie.js"></script>
	<script src="js/jquery.treeview.js" type="text/javascript"></script>

<title>解析XML</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("#browser").treeview({
			toggle: function() {
				console.log("%s was toggled.", $(this).find(">span").text());
			}
		});

		$("#add").click(function() {
			var branches = $("<li><span class='folder'>New Sublist</span><ul>" +
				"<li><span class='file'>Item1</span></li>" +
				"<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
			$("#browser").treeview({
				add: branches
			});
		});
	});
	</script>
<body>
<%--
<% if((session.getAttribute("islogin")) != "success") 
  response.sendRedirect("login.jsp");
%>
 --%>
<h1 id="banner">解析XML</h1>
<a  href="index.jsp"><button>重新输入</button></a><br><br>
	<div id="main">
	<ul id="browser" class="filetree treeview-famfamfam">
	
   <%=  session.getAttribute("xml") %>
    </ul>
    
</div>


</body>
</html>