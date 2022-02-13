<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/01/2022
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
<table class="display" id="tabella_test">
    <caption>Lista Utenti</caption>
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
    <tr class="clickable-row" data-href='../utenti/show?id=${utente.idUtente}'>
        <td>${utente.idUtente}</td>
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


<script>
    $("#tabella_test").DataTable({responsive: true});
</script>