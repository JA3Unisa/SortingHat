<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
<table class="table" id="tabella_test">
    <caption>Lista Categorie</caption>
    <a href="../categorie/create" >Crea Categorie</a>
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Descrizione</th>
        <th>Titolo</th>
        <th>Data e Ora</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
      <c:when test="${categoria.isEmpty()}">
        <tr>
            <td>Nessuna categoria presente!</td>
        </tr>
      </c:when>
        <c:otherwise>
      <c:forEach items="${categorie}" var="categoria">
    <tr>
        <td><a href="../categorie/show?id=${categoria.idCategoria}">${categoria.idCategoria}</a></td>
        <td>${categoria.nome}</td>

        <td>${categoria.descrizione}</td>
        <td>${categoria.titoloDescrizione}</td>
        <td>${categoria.dataOra}</td>
        <td><a href="../categorie/update?id=${categoria.idCategoria}"><i class="fas fa-edit"></i></a></td>
        <td><a href="../categorie/delete?id=${categoria.idCategoria}"><i class="fas fa-trash-alt"></i></a></td>
    </tr>
      </c:forEach>
    </c:otherwise>
    </c:choose>

    </tbody>

</table>

<script>
    $("#tabella_test").DataTable({responsive: true});
</script>