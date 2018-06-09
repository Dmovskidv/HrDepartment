<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>system</title>
    </head>
    <body>
        <style>
            input[type=text], input[type=password],input[type=submit] {
                width: 100%;
                padding: 12px 20px;
                margin: 4px 0;
                box-sizing: border-box;
                font-size: 20px; 
            }
            table{
                margin-top: 30px;
                font-size: 20px;
            }
            h1{
                margin-top: 220px;
                font-size: 35px;
            }
        </style>

        <a href="/system">Return to main page</a>
    <center><h1>Autorisation Employer</h1></center>

    <form:form method="post" modelAttribute="accountemployer" action="/system/login-employer/check">
        <table align="center">

            <tr>
                <td>Login:</td>
                <td><form:input path="login"/></td>
            </tr>

            <tr>
                <td>Password:</td>
                <td><form:password path="password" /></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Send" /></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
