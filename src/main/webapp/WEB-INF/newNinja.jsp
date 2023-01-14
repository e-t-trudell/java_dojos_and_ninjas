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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h3>New Ninja</h3>
   <form:form action="/ninja/create" method="post" modelAttribute="ninja" class="col-lg-6 offset-lg-3">
   		<div class="form-group row align-items-center">
   			<form:label path="dojo">Dojo:</form:label>
   			<form:select path="dojo">
   				<c:forEach var="oneDojo" items="${dojos}">
   						<form:option value="${oneDojo.dojo_id}" path="dojo">
   							<c:out value="${oneDojo.name}"/>
   						</form:option>form:option >
   				</c:forEach>
   			</form:select>
   			<form:errors path="dojo"></form:errors>
   		</div>
   		<div class="form-group row align-items-center">
   			<form:label path="fName">First Name:</form:label>
   			<form:input path="fName"></form:input>
   			<form:errors path="fName"></form:errors>
   		</div>
   		<div class="form-group row align-items-center">
   			<form:label path="lName">Last Name:</form:label>
   			<form:input path="lName"></form:input>
   			<form:errors path="lName"></form:errors>
   		</div>
   		<div class="form-group row align-items-center">
   			<form:label path="age">Age:</form:label>
   			<form:input path="age"></form:input>
   			<form:errors path="age"></form:errors>
   		</div>
   		<div>
   			<button>Create</button>
   		</div>
   </form:form>
</body>
</html>
