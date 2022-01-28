<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
  <jsp:include page="../partials/headS.jsp">
    <jsp:param name="userStyles" value="main,background,profilo"/>
    <jsp:param name="userScripts" value="mobileMenu"/>
    <jsp:param name="title" value="SortingHat - Profilo"/>
  </jsp:include>
</head>
<body>
  <jsp:include page="/WEB-INF/views/partials/background.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/partials/menuDesktop.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/views/partials/menuMobile.jsp"></jsp:include>


</body>
</html>
