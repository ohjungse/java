<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
 table {border-collapse : collapse;}
</style>
</head>
<body>
<% int count = 0; %>
	<table border ='1'>
		<%
			for (int i = 0; i < 3; i++) {
				out.print("<tr>");
				for(int j = 0; j < 4; j++) {
					out.print("<td>");
					out.print("���̺�" + ++count);
					out.print("</td>");
					}
				out.println("</tr>");
			}
		%>
	</table>
	<br>
	<%
	count = 0;
	%>
	
	<table border ='1'>
		<% for (int i = 0; i < 3; i++) {%>
		<tr>
			<% for (int j = 0; j < 4; j++) { %>
			<td>���̺�<%=++count%></td>
			<% } %>
		</tr>
		<% } %>
	</table>
</body>
</html>