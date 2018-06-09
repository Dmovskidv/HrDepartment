<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>main page</title>
    </head>
    <body>

    <style>
        input[type=submit] {
            border: 2px solid #eee;
            height: 70px;
            width: 200px;
            font-size: 20px; 
             
        }
        h1{
            font-size: 50px;
            display: block;
            margin: auto;
        }
        table{
            margin-top: 150px;
        }
    </style>

    <table align="center">
        <tr>
            <td colspan="2" align="center"><h1>Seach workers</h1></td>
        </tr>
        <tr>
            <td>
                <form method="POST" action="/system/login-employer">
                    <input type="submit" value="Login in" />
                </form>
            </td>
            <td>
                <form method="POST" action="/system/formEmployer">
                    <input type="submit" value="Registration" />
                </form>
            </td>
        </tr>
    </table>

    <table align="center">
        <tr>
            <td colspan="2" align="center"><h1>Seach employers</h1></td>
        </tr>
        <tr>
            <td>
                <form method="POST" action="/system/login-worker">
                    <input type="submit" value="Login in" />
                </form>
            </td>
            <td>
                <form method="POST" action="/system/formWorker">
                    <input type="submit" value="Registration" />
                </form>
            </td>
        </tr>
    </table>


</body>
</html>