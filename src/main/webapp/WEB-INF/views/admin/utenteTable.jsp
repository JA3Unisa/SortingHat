<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <caption class="align-center justify-center">Lista Utenti
        <form action="../utenti/delete"  method="post" >
            <input type="text" name="id" placeholder="Elimina utente" style="color: black"/>
        </form></caption>
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
    <c:choose>
    <c:when test="${utenti.isEmpty()}">
        <tr>
            <td>Nessun utente presente!</td>
        </tr>
    </c:when>
    <c:otherwise>
    <c:forEach items="${utenti}" var="utente">
    <tr>
        <td><a href="../utenti/show?id=${utente.idUtente}">${utente.idUtente}</a></td>
        <td>${utente.nome}</td>

        <td>${utente.cognome}</td>

        <td>${utente.email}</td>
        <c:choose>
            <c:when test="${utente.ruolo ==1}">
                <td>Admin</td>
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

        <td><a href="../utenti/update?id=${utente.idUtente}"><i class="fas fa-edit"></i></a></td>
        <td><a href="../utenti/delete?id=${utente.idUtente}"><i class="fas fa-trash-alt"></i></a></td>

    </tr>
    </c:forEach>
    </c:otherwise>
    </c:choose>
    </tbody>

</table>