<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.ResultSet" %>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Registration</title>
</head>
<body>

<table>
<tr>
  <th>Name</th>
  <th>City</th>
  <th>Email</th>
  <th>Mobile</th>
  <th>Delete</th>
  <th>Update</th>
</tr>

<%
  ResultSet result=(ResultSet)request.getAttribute("result");
   while(result.next()){
	   
	   %>
	   <tr>
       <td><%=result.getString(1) %></td>
       <td><%=result.getString(2) %></td>
       <td><%=result.getString(3) %></td>
       <td><%=result.getString(4) %></td>
       
      <td><a href="delete?email=<%=result.getString(3) %>">Delete</a></td>
      <td><a href="update?email=<%=result.getString(3) %>&mobile=<%=result.getString(4) %>">Update</a></td>
       
       </tr>
	   
  <%} %>
</table>

</body>
</html>