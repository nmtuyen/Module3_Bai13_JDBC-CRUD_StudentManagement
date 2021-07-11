<%--
  Created by IntelliJ IDEA.
  User: Admin-Thính
  Date: 7/11/2021
  Time: 12:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Form Add</title>
</head>
<body>
<center>
    <h1>Form Add Student</h1>
    <form action="/Students" method="post">
        <input type="hidden" name="action" value="create">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" id="age"></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="text" name="gender" id="gender"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>Conduct</td>
                <td><input type="text" name="conduct" id="conduct"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button>Create</button>
                </td>
            </tr>
        </table>
</form>
</center>
</body>
</html>
