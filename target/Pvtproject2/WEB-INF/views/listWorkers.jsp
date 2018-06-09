
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <style>
            h1{
                font-size: 40px;
            }
            table {
                border-collapse: collapse; 
            }
            td{
                border: 2px solid black; 
                padding: 10px;
                text-height: 10px;
            }
        </style>

<a href="/system">Return to main page</a>
    <center><h1>Found workers:</h1></center>
        <c:if test="${not empty workers}">

        <table align="center">
            <c:set var="count" value="1" scope="page" />  
            <c:forEach var="listValue" items="${workers}">

                <tr>
                    <td>${count}</td>
                    <td bordercolor="black"> ${listValue.fio}</td>
                    <td> ${listValue.speciality}</td>
                </tr>
                <c:set var="count" value="${count + 1}" scope="page"/> 
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
