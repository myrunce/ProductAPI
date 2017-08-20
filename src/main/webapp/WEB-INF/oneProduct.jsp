<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${product.name}</title>
<style>
	fieldset.editProduct {
		display: inline-block;
	}
	
	fieldset.json{
		text-align:center;
		margin-bottom:50pX;
		display:inline;
	}
	.header{
		text-align:center;
	}
	.edit{
		text-align:center;
	}
</style>
</head>
<body>
	<div class="header">
		<h1>${product.name}</h1>
		<fieldset class="json">
			<p>JSON: ${theproduct}</p>
		</fieldset>
	</div>
	<div class="edit">
	<h3>Edit product</h3>
	<fieldset class="editProduct">
	<h4>Edit Product</h4>
		<form:form method="POST" action="/products/${product.id}" modelAttribute="product"> 
		    <form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label><br><br>
		    
		    <form:label path="description">Description
		    <form:errors path="description"/>
		    <form:input path="description"/></form:label><br><br>
		    
		    <form:label path="price">Price
		    <form:errors path="price"/>
		    <form:input path="price"/></form:label><br><br>
		    
		    <form:hidden path="id" value="${product.id}"/>
		    <input type="submit" value="update"/>
		</form:form>
		</fieldset><br><br>
		
		<a href="/">Back to main page</a>
	</div>
</body>
</html>