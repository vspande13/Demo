<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1>**Edit page**</h1>
${msg}
</head>

<body bgcolor="pink">
<center>
<form action="update">
<pre>

<input type="hidden" name="id" value="${udata.id}">

Name:-    <input type="text" name="name" value="${udata.name}">

Address:- <input type="text" name="address" value="${udata.address}">

Username:-<input type="text" name="uname" value="${udata.uname}">

Password:-<input type="password" name="pass" value="${udata.pass}">

                 <input type="submit" value="update">
</pre>

</form>
</center>
</body>

</html>