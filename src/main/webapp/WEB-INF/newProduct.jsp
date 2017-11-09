<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>

	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2>New Product</h2>
					<p><a href="/categories/new">Add Category</a></p>
					<form:form method="POST" action="/products/new" modelAttribute="product">
						<form:hidden path="id"/>
						<form:label path="name">Name:
						<form:errors path="name"/>
						<form:input path="name" class="form-control"/></form:label>
						<br>
						<br>
						<form:label path="description">Description:
						<form:errors path="description"/>
						<form:input path="description" class="form-control"/></form:label>
						<br>
						<br>
						<form:label path="price">Price:
						<form:errors path="price"/>
						<form:input path="price" type="number" step="0.01" min="0" class="form-control"/></form:label>
						<br>
						<br>
						<input type="submit" value="Create" class="btn btn-success"/>
					</form:form>
				</div>
				<div class="col-md-6"></div>
			</div>
		</div>
	</body>
</html>