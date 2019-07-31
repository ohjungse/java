<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table {border-collapse : collapse}
</style>
</head>
<body>
	<table border ='1'>
	
		<%
			for (int i = 1; i <=9; i++) {
				out.print("<tr>");
				for(int j = 1; j <=9; j++) {
					out.print("<td>");
					out.print(i+"x"+j +"="+ (i*j));
					out.print("</td>");
					}
				out.println("</tr>");
			}
		%>
	</table>
	<br>
		<table border ='1'>
	
		<%
			for (int i = 0; i < 9; i++) {
				out.print("<tr>");
				for(int j = 0; j < 9; j++) {
					out.print("<td>");
					out.print((i+1)+"x"+(j+1) +"="+ ((i+1)*(j+1)));
					out.print("</td>");
					}
				out.println("</tr>");
			}
		%>
	</table>
	<br>
	<table border = '1'>
<!-- 	3*4=12 3*5=15 3*6=18..... -->
	<%for (int i = 0; i<=9; i++) {%>
		<tr>	
			<%for (int j = 0; j<=9; j++) {%>
	 				<td><%=i+"X"+j+" = "+ i*j%></td>
			<% } %>
	</tr>
	<% } %>
	</table>
	
</body>
</html>