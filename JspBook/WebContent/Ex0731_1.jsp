<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%! //int count = 0; %>
<body>
<% 
	for (int i = 0; i < 5; i++) 
	{
	out.print("<h1>JSP Test</h1>");
	}
%>
<h2>JSP Test 2</h2>
<%
	//out.println(++count); //��ũ��Ʋ��
	out.print(myMethod(0));

	out.println("<h3>JSP</h3>");
%>

<%!
	public int myMethod(int count) {
	return ++count;
}
%>
</body>
</html>