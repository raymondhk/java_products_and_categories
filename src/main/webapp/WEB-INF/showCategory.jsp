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
					<h2><c:out value="${category.name}"/></h2>
					
				</div>
				<div class="col-md-6"></div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Categories</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${category.products}" var="product">
								<tr>
									<td>${product.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
				<div class="col-md-6">
					<form:form method="POST" action="/categories/${category.id}" modelAttribute="category">
						<form:hidden path="id"/>
							<form:label path="products">Products:
							<form:select path="products" class="form-control">
								<option disabled selected>Select Product</option>
								<c:forEach items="${products}" var="product">
									<form:option value="${product}" label="${product.name}"/>
								</c:forEach>
							</form:select>
							</form:label>
						<br>
						<br>
						<input type="submit" value="Add" class="btn btn-success"/>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>