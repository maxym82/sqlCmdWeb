<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
        Table content
    </head>
    <body>
        <br>
        <table border=1>
            <c:forEach items="${table}" var="row">
                <tr>
                    <c:forEach items="${row}" var="element">
                        <td>
                            "${element}"
                        </td>
                    </c:forEach>
                <tr>
            </c:forEach>
        </table>
        <%@include file="footer.jsp" %>
    </body>
</html>