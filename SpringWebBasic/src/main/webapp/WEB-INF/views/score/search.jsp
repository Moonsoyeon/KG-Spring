<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>개별 점수 조회</h2>

<%--
	- /selectOne 요청을 통해 해당 학번을 가진 학생의 성적정보를 
	조회하여 search-result.jsp에서 해당 정보를 화면에 출력하세요.
 --%>

<form action="/web/score/selectOne">
<p>
# 조회할 학번: <input type="text" name="stuNum" size="5">
<input type="submit" value="조회">
</p>
</form>

<p style="color:red;">${msg}</p>

</body>
</html>