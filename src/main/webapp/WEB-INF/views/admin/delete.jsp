<%--
  Created by IntelliJ IDEA.
  User: davidedisarno
  Date: 25/01/22
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="/WEB-INF/views/partials/headS.jsp">
        <jsp:param name="userStyles" value="main,background,homepage"/>
        <jsp:param name="userScripts" value="mobileMenu"/>
        <jsp:param name="title" value="SortingHat - delete"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>

<main class="app dashboard">

    <%@include file="../partials/adminBar.jsp"%>
    <section class="content grid-y">

        <div class="body grid-x justify-center ">
            <%--Se esiste l'alert lo include --%>
            <c:if test="${not empty alert}">
                <%@include file="../partials/alert.jsp"%>
            </c:if>
        </div>

    </section>

</main>



</body>
</html>
