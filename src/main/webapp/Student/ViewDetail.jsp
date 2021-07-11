<%--
  Created by IntelliJ IDEA.
  User: Admin-Thính
  Date: 7/11/2021
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <form action="/Students" method="post">
        <input type="hidden" name="action">
        <table border="1">
            <captian>Student Detail</captian>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
                <td>Gender</td>
                <td>Address</td>
                <td>Conduct</td>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${student.id}"></td>
                <td><input type="text" name="name" value="${student.name}"></td>
                <td><input type="text" name="age" value="${student.age}"></td>
                <td><input type="text" name="gender" value="${student.gender}"></td>
                <td><input type="text" name="address" value="${student.address}"></td>
                <td><input type="text" name="conduct" value="${student.conduct}"></td>
                <td><a href="/Students?action=edit&id=${student.id}">Edit</a></td>
                <td><a href="/Students?action=delete&id=${student.id}">Delete</a></td>
            </tr>
        </table>
    </form>
</center>


</body>
</html>
