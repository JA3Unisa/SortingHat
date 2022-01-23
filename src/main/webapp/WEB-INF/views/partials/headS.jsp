<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
<title>${param.title}</title>
<meta name="description" content="Sorting Hat">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/icons/logo2.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone-no">
<meta name="apple-mobile-web-app-title" content="Sorting Hat">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="apple-touch-icon" href="${pageContext.request.contextPath}/icons/logo2.png">
<link rel="apple-touch-startup-image" href="${pageContext.request.contextPath}/icons/logo2.png">
<meta name="theme-color" content="#FFFFFF">
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

<c:if test="${not empty param.userStyles}">
    <c:forTokens items="${param.userStyles}" delims="," var="userStyles">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/${userStyles}.css">
    </c:forTokens>
</c:if>

<c:if test="${not empty param.errorStyles}">
    <c:forTokens items="${param.errorStyles}" delims="," var="errorStyle">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/errors/${errorStyle}.css">
    </c:forTokens>
</c:if>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validate-plugin.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous" defer></script>

<c:if test="${not empty param.userScripts}">
    <c:forTokens items="${param.userScripts}" delims="," var="userScript">
        <script src="${pageContext.request.contextPath}/js/user/${userScript}.js" defer></script>
    </c:forTokens>
</c:if>

<c:if test="${not empty param.customerAjaxScripts}">
    <c:forTokens items="${param.customerAjaxScripts}" delims="," var="customerAjaxScript">
        <script src="${pageContext.request.contextPath}/js/customer/ajax/${customerAjaxScript}.js" defer></script>
    </c:forTokens>
</c:if>