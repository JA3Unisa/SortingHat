<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Descrizione</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <td><a href="../categorie/show?id=${categoria.idCategoria}">${categoria.idCategoria}</a></td>
        <td>${categoria.nome}</td>

        <td>${utente.descrizione}</td>
    </tr>

    </tbody>

</table>