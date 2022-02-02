<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
<table class="table" id="tabella_test">
    <caption>Lista Discussioni
        <a href="../discussioni/create" >Crea Discussioni</a>
    </caption>
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

        <td><a href="../discussioni/update?id=${discussione.idDiscussione}"><i class="fas fa-edit"></i></a></td>
        <td><a href="../discussioni/delete?id=${discussione.idDiscussione}"><i class="fas fa-trash-alt"></i></a></td>
    </tr>

    </c:forEach>
    </c:otherwise>
    </c:choose>
    </tbody>

</table>

<script>
    $("#tabella_test").DataTable({responsive: true});
</script>