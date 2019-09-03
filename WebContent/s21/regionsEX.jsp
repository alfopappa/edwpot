<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Country</title>
</head>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}
table, th, td {
  border: 1px solid black;
}
th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: yellow}

th {
  background-color: white;
  color: black;
}
</style>
<body>
    <h1>Paesi</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="country" items="${countries}">
            <tr>
                <td>${country.id}</td>
                <td>${country.name}</td>
            </tr>
        </c:forEach>
    </table>
     <p>
        Back to <a href="/edwpot/regionsEX.html">home</a>
    </p>
</body>
</html>