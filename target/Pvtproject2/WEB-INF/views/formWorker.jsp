
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add worker</title>
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
                margin-top: 150px;
                font-size: 35px;
            }
        </style>
        <a href="/system">Return to main page</a>
    <center><h1>Registration new Worker</h1></center>
        <form:form method="post" commandName="worker" action="/system/formWorker/save">
        <table align="center">
            <tr>
                <td>Fio</td>
                <td><form:input path="fio" /></td>
            </tr>

            <tr>
                <td>Speciality</td>
                <td><form:input path="speciality" /></td>
            </tr>

            <tr>
                <td>Login:</td>
                <td><form:input path="account.login" /></td>
            </tr>

            <tr>
                <td>Password:</td>
                <td><form:password path="account.password" /></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Send" /></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
