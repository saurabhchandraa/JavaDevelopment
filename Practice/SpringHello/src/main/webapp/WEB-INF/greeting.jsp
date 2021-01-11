<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="greeting.css" var="mainCss" />
<link href="${greeting}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
 <p> Hello ${name}</p>
</body>
</html>