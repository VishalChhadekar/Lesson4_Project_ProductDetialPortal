
<%@page import="com.hibernate.entity.Product"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.hibernate.util.HibernateUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
		table, th, td {
			border: .5px solid black;
		}
	</style>
<meta charset="UTF-8">
<title>read-product</title>
</head>
<body>
	<%
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	List<Product> products = s.createQuery("from Product").list();
	request.setAttribute("productList", products);

	%>
<h2>Product List</h2><br>
	<table style="width:100%">
		<tr>
			<th>Product</th>
			<th>Brand</th>
			<th>Model</th>
			<th>Price</th>
		</tr>

		<core:forEach items="${productList}" var="pro">
			<tr>
				
				<td>${pro.getpName()}</td>
				<td>${pro.getpBrand()}</td>
				<td>${pro.getpModel()}</td>
				<td>${pro.getpPrice()}</td>
			</tr>
		</core:forEach>
	</table>

</body>
</html>