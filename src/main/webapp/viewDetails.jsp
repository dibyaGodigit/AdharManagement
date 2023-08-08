<%@page import="com.digit.hibernate.model.Adhar"%>
<%@page import="com.digit.hibernate.model.HibernateManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
<%


session = request.getSession();
String id = (String)session.getAttribute("id");

HibernateManager hbm = new HibernateManager();
Adhar a= hbm.selectSpecific(id);

out.println("<h1> Adhar Number : </h1>"+a.getId()+"<br><br>");
out.println("<h1> Citizen Name : </h1>"+a.getName()+"<br><br>");
out.println("<h1> Date OF Birth: </h1>"+a.getDob()+"<br><br>");
out.println("<h1> Email        : </h1>"+a.getEmail()+"<br><br>");
out.println("<h1> Address      : </h1>"+a.getAddress()+"<br><br>");
out.println("<h1> Phone No 	   : </h1>"+a.getPhone()+"<br><br>");
out.println("<h1> Country Name : </h1>"+a.getCountry()+"<br><br>");

%>
<br><br>
<a href="Home.html">Redirect</a>
</body>
</html>