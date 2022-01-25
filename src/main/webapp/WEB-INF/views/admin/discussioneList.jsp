<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25/01/2022
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="it">
         <head>
             <jsp:include page="/WEB-INF/views/partials/headS.jsp">
                 <jsp:param name="userStyles" value="main,background,homepage"/>
                 <jsp:param name="userScripts" value="mobileMenu"/>
                 <jsp:param name="title" value="SortingHat - discussioneList"/>
             </jsp:include>
    </head>
         <body>
         <jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
         <jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
         <jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>

         <main class=" app dashboard">

             <%@include file="../partials/adminBar.jsp"%>
             <section class="content-grid-y">
                 <div class ="body grid-x justify-center">
                     <section class="grid-y cell justify-center">
                         <%@include file="discussioneTable.jsp"%>
                         <jsp:include page="/WEB-INF/views/partials/paginator.jsp">
                             <jsp:param name="risorse" value="discussione"/>
                         </jsp:include>
                     </section>





                 </div>
             </section>


         </main>





</body>
</html>
