<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i = 0; i < 5; i++){
		for(int j = 0; j < i+1; j++){
			out.print("*");
		}
		out.print("<br>");
	}
out.print("<br>");
%>
<%
	for(int i = 0; i < 5; i++){
		for(int j = 0; j < 5-i; j++){
			out.print("*");
			
		}
		out.print("<br>");
	}
out.print("<br>");
%>
<%
	for(int i = 0; i < 5; i++){
		for(int j = 5; j > i; j--){
			out.print("*");
			
		}
		out.print("<br>");
	}
out.print("<br>");
%>

</body>
</html>