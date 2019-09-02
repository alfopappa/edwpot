<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sql:query dataSource="jdbc/hr" var="regions">
select region_name, country_name, country_id
from regions join countries
using(region_id)
where region_id = 1</sql:query>
<title>Europe</title>
</head>
<body>
    <table>
        <tr>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach var="cur" items="${regions.rows}">
            <tr>
            <td>${cur.COUNTRY_ID}</td>
            <td>${cur.COUNTRY_NAME}</td>
                
                    
            </tr>
        </c:forEach>
    </table>
</body>
</html>