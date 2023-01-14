<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
 
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Dojo</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
   <table class=" border border-4 border-warning table table responsive table-striped table-bordered table-hover.active p-5">
   		<thead class="container-fluid">
   			<tr >
   				<th class="col-lg-3">First Name</th>
   				<th class="col-lg-3">Last Name</th>
   				<th class="col-lg-3">Age</th>
   						
   			</tr>
   		</thead>
   		<tbody>
   			<c:forEach var="ninja" items="${dojo.ninjas}">
   			<tr>
   				<td>
   					<c:out value="${ninja.fName}"></c:out>
   				</td>
   				<td>
   					<c:out value="${ninja.lName}"></c:out>
   				</td>
   				<td>
   					<c:out value="${ninja.age}"></c:out>
   				</td>
   			
   					<%-- <td><a href="/language/edit/${dojo.ninjas.id}"><button>Edit Me</button></a></td>
   					<td><form action="/language/${dojo.ninjas.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete">
						</form>
					</td>  --%>
   			</tr>
   			</c:forEach>
   			</tbody>
   	</table>
   	<a href="/dojo/new">New Dojo</a>
	<a href="/ninja/new">New Ninja</a>
</body>
</html>
