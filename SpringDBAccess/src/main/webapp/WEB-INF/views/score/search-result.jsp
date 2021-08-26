<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>${stu.stuName}학생 개별 성적 조회</h2>

<p>

# 국어: ${stu.kor}점<br>
# 영어: ${stu.eng}점<br>
# 수학: ${stu.math}점<br>
# 총점: ${stu.total}점<br>
# 평균: ${stu.average}점<br>

</p>

<a href="/web/score/register">다른 점수 등록하기</a>
<a href="/web/score/list">점수 전체 조회</a>
<a href="/web/score/search">점수 개별 조회</a>

</body>
</html>