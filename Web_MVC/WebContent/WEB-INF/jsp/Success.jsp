<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<center>
<head>
<h1>**Success page**</h1>
<script type="text/javascript">
function add(){
	alert("add()")
	document.myform.action="registerpage";
	document.myform.submit();
}
function del(){
	alert("del()")
	document.myform.action="del";
	document.myform.submit();
}
function edit(){
	alert("edit()")
	document.myform.action="edit";
	document.myform.submit();
}
</script>
</head>
<body>
<form name="myform">
<table border="2">
<tr><th>Id</th><th>Name</th><th>Address</th><th>Username</th><th>password</th></tr>
<tr>
<c:forEach items="${udata}" var="udata">
<td><input type="radio" name="id" value="${udata.id}"></td>
<td>${udata.name}</td>
<td>${udata.address}</td>
<td>${udata.uname}</td>
<td>${udata.pass}</td>
</tr>
</c:forEach>
<tr><td colspan="6" align="center"><input type="button" value="Add" onclick="add()">
<input type="button" value="Delete" onclick="del()">
<input type="button" value="Edit" onclick="edit()">
</table>
</form>
</body>
</center>
</html>