<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style>
		table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
		fieldset.newProduct{
			display:inline-block;
		}
		.add{
			text-align: center;
		}
		.header{
			text-align:center;
		}
	</style>
</head>
<body>
	<div class="header">
		<h1>Products API</h1>
		<p><a href="/products">Click here for raw JSON data</a>
	</div>
	<Fieldset>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>TimeStamp</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href="/products/${product.id}">${product.name}</a></td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.timeStamp}</td>
						<td><a href="/delete/${product.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</Fieldset><br><br>
	<div class="add">
		<h1>Add a new product to the API!</h1>
		<fieldset class="newProduct">
		<h4>New Product</h4>
		<form:form method="POST" action="/" modelAttribute="product"> 
		    <form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label><br><br>
		    
		    <form:label path="description">Description
		    <form:errors path="description"/>
		    <form:input path="description"/></form:label><br><br>
		    
		    <form:label path="price">Price
		    <form:errors path="price"/>
		    <form:input path="price"/></form:label><br><br>
		    
		    <input type="submit" value="Create"/>
		</form:form>
		</fieldset>
	</div>
</body>
</html>