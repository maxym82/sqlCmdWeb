<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>SQLCMDWEB</title>
    </head>
    <body>
        Hello World
        <c:forEach items="$(menuItems)" var="item">
            <a href="/sqlcmdweb/projects?category=$ (item.id)"><c:out value="$(item.name)"/> </a>
        </c:forEach>
    </body>
</html>