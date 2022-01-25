<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <caption class="align-center justify-center">Lista Discussioni<a href="../discussioni/create" >Crea Discussione</a>
        <form action="../discussioni/delete"  method="post" >
            <input type="text" name="id" placeholder="Elimina discussione" style="color: black"/>
        </form></caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Corpo</th>
        <th>Data e Ora</th>
        <th>Titolo</th>


    </tr>
    </thead>
    <tbody>
    <c:choose>
    <c:when test="${discussioni.isEmpty()}">
        <tr>
            <td>Nessuna discussione presente!</td>
        </tr>
    </c:when>
    <c:otherwise>
    <c:forEach items="${discussioni}" var="discussione">
    <tr>
        <td><a href="../discussioni/show?id=${discussione.idDiscussione}">${discussione.idDiscussione}</a></td>
        <td>${discussione.corpo}</td>

        <td>${discussione.dataOra}</td>

        <td>${discussione.titolo}</td>

        <td><a href="../discussioni/update?id=${discussione.idDiscussione}" >Modifica discussione</a></td>

    </tr>

    </c:forEach>
    </c:otherwise>
    </c:choose>
    </tbody>

</table>