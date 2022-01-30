
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="context" value="${pageContext.request.contextPath}"/>
<title>${param.title}</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/png" href="http://www.w3.org/2000/svg">
<link href="${context}/css/home.css" rel="stylesheet">
<link href="${context}/css/dashboard.css" rel="stylesheet">
<link href="${context}/css/liste.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${context}/js/crm.js" defer></script>



<c:if test="${not empty param.style}">
    <c:forTokens items="${param.styles}" delims="," var="style">
        <link rel="stylesheet" href="${context}/css/${style.css}">
    </c:forTokens>
</c:if>
