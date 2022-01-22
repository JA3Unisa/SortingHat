$(document).ready(function (){
    function openMenuMobile(){
        $( "#main_menu_mobile" ).removeClass( "menuMobileChiuso" ).addClass( "menuMobileAperto" );
    }

    function closeMenuMobile(){
        $( "#main_menu_mobile" ).removeClass( "menuMobileAperto" ).addClass( "menuMobileChiuso" );
    }
})
