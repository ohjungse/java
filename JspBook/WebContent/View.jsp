<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String b_num = request.getParameter("b_num"); //인터넷상에서 넘어오는 모든 변수는 문자열 타입
	int bi_num = Integer.parseInt(b_num);	//정수로 사용하기 위해 형변환
	Connection conn = null; //데이터베이스 연결 객체 선언 (아직 메모리에 없음)
	PreparedStatement pstmt = null; //SQL 문장 처리 객체 (아직 메모리에 없음)
	String sql = ""; //쿼리작성용 문자열
 	
	try {
		Class.forName("org.sqlite.JDBC"); //JDBC 드라이버 로드
		out.print("드라이버로드OK<br>");
		conn = DriverManager.getConnection("jdbc:sqlite:D:\\sqlite3\\mydb.db");
		out.print("디비연결OK<br>");
		sql = "select * from board where b_num = ?";
		pstmt = conn.prepareStatement(sql); //쿼리 실행용 객체 생성
		pstmt.setInt(1, bi_num);
		pstmt.executeUpdate(); //pstmt 실행
		response.sendRedirect("./List.jsp");
	} catch (Exception e) {
		out.print(e.toString() + "DB 에러");
	}
	%>
	<a href = './Write.jsp'>글쓰기</a><br>
	<h1>게시판 리스트</h1>
	<table border = '1'>
	<tr>
		<td class = 'htitle' width ='80'>번호</td>
		<td class = 'htitle' width ='300'>제목</td>
		<td class = 'htitle' width ='100'>작성자</td>
		<td class = 'htitle' width ='80'>조회수</td>
		<td class = 'htitle' width ='150'>작성일</td>
		<td class = 'htitle' width ='80'>삭제</td>
	</tr>	
	<%
	while (rs.next()){
		int b_num = rs.getInt("b_num"); //테이블의 필드명을 매개변수로 사용
		String b_subject = rs.getString("b_subject");
		String b_name = rs.getString("b_name");
		int b_visit = rs.getInt("b_visit");
		String b_date = rs.getString("b_date");
		String b_contents = rs.getString("b_contents");	
	
%>
<%
	try { 
		
		pstmt.close();	//객체 닫기
		conn.close(); //객체 닫기
	} catch (Exception e) {
		out.print(e.toString() + "DB닫기 에러");
	}
	%>
</body>
</html>