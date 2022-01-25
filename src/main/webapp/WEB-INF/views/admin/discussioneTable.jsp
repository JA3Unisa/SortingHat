<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Corpo</th>
        <th>Data e Ora</th>
        <th>Titolo</th>


    </tr>
    </thead>
    <tbody>

    <tr>
        <td><a href="../discussione/show?id=${discussione.idDiscussione}">${discussione.idDiscussione}</a></td>
        <td>${discussione.corpo}</td>

        <td>${discussione.dataOra}</td>

        <td>${discussione.titolo}</td>


    </tr>

    </tbody>

</table>