<%--
  Created by IntelliJ IDEA.
  User: VENKATARAJU
  Date: 25-12-2025
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<form action="saveStudent" method="post">
    Name: <input type="text" name="name" /><br/><br/>
    Email: <input type="text" name="email" /><br/><br/>
    Course: <input type="text" name="course" /><br/><br/>

    <input type="submit" value="Add Student"/>
</form>

<br/>
<a href="students">View Students</a>

</body>
</html>

