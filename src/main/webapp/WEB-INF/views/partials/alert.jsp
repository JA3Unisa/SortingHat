<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="notifica ${alert.tipo}">
    <ul >
        <c:forEach var="msg" items="${alert.messaggi}">
            <li>${msg}</li>
        </c:forEach>

        <span id="notifica-chiusa" class="chiusa">

    </span>
    </ul>
</div>