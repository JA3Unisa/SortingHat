<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 24/01/22
  Time: 19:35
  To change this template use File | Settings | File Templates.

  .notifica{
    position: relative;
    color: white;
    border-radius: 10px;

    margin-bottom: .2rem;
    text-align: center;
    padding: initial;
}
.notifica.success{
    background-color: darkcyan;
    margin: auto;
}
.notifica.danger{
    background-color: red;
    color: white;
    margin: auto;
    font-size: larger;
    text-align: justify;
}
.notifica .chiusa{
    position: absolute;
    top:10px;
    right:10px;
    fill:white;

    @media (min-width: 509px){

    .notifica{
        padding: 30px;
    }
}

@media (min-width: 760px) {

    .notifica.danger{
        font-size: 26px;
    }

}
}
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