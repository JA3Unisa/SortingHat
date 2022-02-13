<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.js"></script>
<table class="table" id="tabella_test">
    <caption>Lista Risposte
       <a href="../risposte/create" >Crea Risposta</a>
           </caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Corpo</th>
        <th>dataOra</th>

    </tr>
    </thead>
    <tbody>
    <c:choose>
       <c:when test="${risposte.isEmpty()}">
        <tr>
            <td>Nessuna risposta presente!</td>
        </tr>
       </c:when>
      <c:otherwise>
        <c:forEach items="${risposte}" var="risposta">
    <tr>
        <td><a href="../risposte/show?id=${risposta.idRisposta}">${risposta.idRisposta}</a></td>
        <td>${risposta.corpo}</td>

        <td>${risposta.dataOra}</td>

        <td><a href="../risposte/update?id=${risposta.idRisposta}"><i class="fas fa-edit"></i></a></td>
        <td><a href="../risposte/delete?id=${risposta.idRisposta}"><i class="fas fa-trash-alt"></i></a></td>

    </tr>
       </c:forEach>
      </c:otherwise>
    </c:choose>
    </tbody>

</table>


<script>
    $("#tabella_test").DataTable({responsive: true});
</script>