
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <style>
            input[type=submit] {
                border: 2px solid #eee;
                height: 70px;
                width: 200px;
            }
            h1{
                font-size: 50px;
                display: block;
                margin: auto;
            }
            table{
                margin-top: 150px;
            }
            p{
                font-size: 30px;
            }
        </style>
        <a href="/system">Return to main page</a>
        <p>You're logged as an   <strong>«${employer.company}»</strong> </p>
        <table align="center">
            <tr>
                <td colspan="2" align="center"><h1>Choose task</h1></td>
            </tr>
            <tr>
                <td>
                    <form method="POST" action="/system/${employer.company}/${employer.employerId}/workers-list">
                        <input type="submit" value="Select workers"  />
                    </form>
                </td>
                <td>
                    <form method="POST" action="/system">
                        <input type="submit" value="Return main menu" />
                    </form>
                </td>
            </tr>
        </table>

    </body>
</html>
