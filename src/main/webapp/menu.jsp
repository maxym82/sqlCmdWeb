<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
    </head>
    <body>
        <br>
        <c:forEach items="${items}" var="item">
            <a href="${item}">${item}</a> <br>
        </c:forEach>
    </body>
</html>