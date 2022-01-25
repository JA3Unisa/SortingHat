<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>E-mail</th>
        <th>Ruolo</th>
        <th>Tipo</th>

    </tr>
    </thead>
    <tbody>

    <tr>
        <td><a href="../clienti/show?id=${utente.idUtente}">${utente.idUtente}</a></td>
        <td>${utente.nome}</td>

        <td>${utente.cognome}</td>

        <td>${utente.email}</td>
        <c:choose>
            <c:when test="${utente.ruolo ==1}">
                <td>Admin</td>
            </c:when>
            <c:when test="${utente.ruolo ==2}">
                <td>Moderatore</td>
            </c:when>
            <c:otherwise>
                <td>Utente</td>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${utente.universitario}">
                <td>Universitario</td>
            </c:when>
            <c:otherwise>
                <td>Ordinario</td>
            </c:otherwise>
        </c:choose>



    </tr>

    </tbody>

</table>