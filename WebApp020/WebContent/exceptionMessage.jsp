<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

    Exception exception = (Exception) request.getAttribute("exception");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>例外ページ</title>
</head>
<body>
   <h1>例外のprintStackTrace</h1>
   <pre>
      <% exception.printStackTrace(new PrintWriter(out)); %>
   </pre>
   
</body>
</html>