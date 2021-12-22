<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="grid-x paginator">
    <c:forEach var="page" begin="1" end="${pages}">
        <li>
            <a href="../${param.risorse}/?page=${page}">${page}</a>
        </li>
    </c:forEach>
</ul>
