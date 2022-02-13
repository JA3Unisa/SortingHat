<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="it">
         <head>
             <jsp:include page="/WEB-INF/Interface/partials/headS.jsp">
                 <jsp:param name="userStyles" value="main,background,homepage,adminDashboard"/>
                 <jsp:param name="userScripts" value="mobileMenu"/>
                 <jsp:param name="title" value="SortingHat - discussioneList"/>
             </jsp:include>
    </head>
         <body>
         <jsp:include page="/WEB-INF/Interface/partials/background.jsp"></jsp:include>
         <jsp:include page="/WEB-INF/Interface/partials/menuDesktop.jsp"></jsp:include>
         <jsp:include page="/WEB-INF/Interface/partials/menuMobile.jsp"></jsp:include>

         <main class=" app dashboard">

             <%@include file="../partials/adminBar.jsp"%>
             <div id="listaUtenteUtenteList">
                 <%@include file="discussioneTable.jsp"%>
                 <jsp:include page="../partials/paginator.jsp">
                     <jsp:param name="risorse" value="discussioni"/>
                 </jsp:include>
             </div>

         </main>





</body>
</html>
