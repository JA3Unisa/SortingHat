<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Corpo</th>
        <th>dataOra</th>

    </tr>
    </thead>
    <tbody>

    <tr>
        <td><a href="../risposte/show?id=${risposta.idRisposta}">${risposta.idRisposta}</a></td>
        <td>${risposta.Corpo}</td>

        <td>${risposta.dataOra}</td>


    </tr>

    </tbody>

</table>