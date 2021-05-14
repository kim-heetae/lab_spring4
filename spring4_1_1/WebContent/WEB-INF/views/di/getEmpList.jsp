<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	List<Map<String, Object>> empList = (List<Map<String, Object>>)request.getAttribute("empList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록 페이지</title>
</head>
<body>
getEmpList.jsp 호출 성공 </br>
사원목록 페이지입니다.</br>
</body>
</html>