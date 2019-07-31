<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel = "stylesheet"
			href = "http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
 <%
 String greeting = "Welcome to Shopping Mall!!!";
 String tagline = "장터 환영합니다."; 
 %>
	<nav class = "navbar navbar-expand navbar-dark bg-dark">
		<div class = "container">
			<div class = "navbar-header">
				<a class = "navbar-brand" href = "./Ex0731_9.jsp">Home</a>			
			</div>		
		</div>	
	</nav>
	<div class="jumbotron">
		<div class="container">
			<h1 class = "display-3">
				<%= greeting %>
			</h1>		
		</div>
	</div>
</body>
</html>