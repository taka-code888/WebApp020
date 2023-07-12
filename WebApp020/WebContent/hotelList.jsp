<%-- 
<%@page import="jp.hit.hotels.bean.Hotel"%>
<%@page import="java.util.List"%>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<%

	@SuppressWarnings("unchecked")
	List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotels");
%>
--%>
<!DOCTYPE html>
<html>
<head>
           <meta charset="UTF-8">
           <title>ホテル一覧</title>
</head>
<body>
　    <table border="1">
       <tr bgcolor="#8eafed">
          <th>ホテル名</th>
          <th>最寄り駅</th>
          <th>部屋タイプ</th>
          <th>料金</th>
       </tr>
<%-- 
		<% for (Hotel hotel : hotels) { %>
		<tr>
			<td><%= hotel.getName() %></td>
			<td><%= hotel.getNearestStation() %></td>
			<td><%= hotel.getRoomType() %></td>
			<td><%= hotel.getCharge() %></td>
		</tr>
		<% } %>
--%>
       <c:forEach var="hotel" items="${hotels}">
          <tr>
             <td><c:out value="${hotel.name }" /></td>
             <td><c:out value="${hotel.nearestStation }" /></td>
             <td><c:out value="${hotel.roomType }" /></td>
             <td><c:out value="${hotel.charge }" /></td>
          </tr>
       </c:forEach>
      </table>
</body>
</html>