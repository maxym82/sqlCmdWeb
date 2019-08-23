<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
    </head>
    <body>
        <form action="connect" method="post">
            <table>
                <tr>
                    <td>DataBase name</td>
                    <td><input type="text" name="dbname"/></td>
                </tr>
                <tr>
                    <td>User name</td>
                    <td><input type="text" name="user"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Connect"/></td>
                </tr>
            </table>
        </form>
        <%@include file="footer.jsp" %>
    </body>
</html>