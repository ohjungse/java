<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		public int sum(int a, int b){
			return a + b;
	}
	%>
	<%
		out.print("�� ���� ����" + sum(2, 3) + "<br>");
	%>
</body>
</html>