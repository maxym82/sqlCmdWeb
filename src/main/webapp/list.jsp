<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
        Tables available:
    </head>
    <body>
        <br>
        <table border=1>
            <c:forEach items="${tables}" var="table">
                  <tr>
                     <td> "${table}" </td>
                  </tr>
            </c:forEach>
        </table>
        <%@include file="footer.jsp" %>
    </body>
</html>