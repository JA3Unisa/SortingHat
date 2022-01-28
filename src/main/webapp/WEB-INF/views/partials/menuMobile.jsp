<div id="menu_mobile">
  <i class="fas fa-bars" id="openMobileMenu" style="display: none" onclick="openMenuMobile()"></i>
  <div id="logo_mobile">
    <svg id="img" width="57" height="56" viewBox="0 0 57 56" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M40.8559 29.3537L42.4583 36.5C38.6359 39.9599 33.6756 41.9263 28.5 42.0334C23.3243 41.9263 18.3641 39.9599 14.5416 36.5C14.5416 36.5 15.4796 33.4844 16.8727 29.2154C7.2666 30.9667 0.583313 34.8013 0.583313 39.2667C0.583313 45.3783 13.0816 55.8667 28.5 55.8667C43.9184 55.8667 56.4166 45.3783 56.4166 39.2667C56.4166 34.9147 50.0684 31.1631 40.8559 29.3537Z" fill="black"/>
      <path d="M28.5 30.9667C32.7548 30.9047 36.8896 29.5594 40.3534 27.1099L36.875 11.6L45.25 22.6501C46.5802 21.168 47.5289 19.3889 48.015 17.4648C48.5011 15.5406 48.5103 13.5284 48.0417 11.6C45.25 3.29999 31.2917 0.533333 28.5 0.533333C26.2416 0.533333 18.3579 24.5508 17.3948 27.5858C20.6922 29.746 24.5475 30.9197 28.5 30.9667Z" fill="black"/>
    </svg>
    <p id="title_mobile">Sorting Hat</p>
  </div>
  <div id="main_menu_mobile" class="menuMobileChiuso">
    <i class="fas fa-times" id="close" onclick="closeMenuMobile()"></i>
    <div id="scelte_mobile">
      <a href="${pageContext.request.contextPath}/pages/" class="selected">Home</a>
      <div class="separatorDot"></div>
      <a href="${pageContext.request.contextPath}/pages/aboutUs">Chi siamo</a>
      <div class="separatorDot"></div>
      <a href="${pageContext.request.contextPath}/pages/contribuisci">Contribuisci</a>
      <div class="separatorDot"></div>
      <a href="${pageContext.request.contextPath}/pages/forum">Forum</a>
    </div>
    <div id="utente_mobile">
     <a href="${pageContext.request.contextPath}/pages/login">Login</a>
<%--    <a href="${authenticated? '${pageContext.request.contextPath}/utenti/profilo' :  '${pageContext.request.contextPath}/pages/login'}" >${authenticated? utenteSession.nome : 'Login' }</a>
--%>
</div>
</div>
</div>