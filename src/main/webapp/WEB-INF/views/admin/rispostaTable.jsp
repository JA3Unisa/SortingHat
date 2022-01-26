<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<table class="table">
    <caption class="align-center justify-center">Lista Risposte<a href="../risposte/create" >Crea Risposta</a>
        <form action="../risposte/delete"  method="post" >
            <input type="text" name="id" placeholder="Elimina risposta" style="color: black"/>
        </form></caption>
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

        <td><a href="../risposte/update?id=${risposta.idRisposta}" >Modifica Risposta</a></td>

    </tr>
       </c:forEach>
      </c:otherwise>
    </c:choose>
    </tbody>

</table>