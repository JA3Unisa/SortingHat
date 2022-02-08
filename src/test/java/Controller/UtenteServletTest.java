package Controller;

import Model.Utente.Utente;
import Model.Utente.UtenteFormMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UtenteServletTest {

    HttpServletRequest request;
    @Mock HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        request = Mockito.mock(HttpServletRequest.class);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFullName() throws IOException, ServletException {
        //c7ad44cbad762a5da0a452f9e854fdc1e0e7a52a38015f23f3eab1d80b931dd472634dfac71cd34ebc35d16ab7fb8a90c81f975113d6c7538dc69dd8de9077ec
        Utente validUtente = new Utente( -1,"Ermene","Gildo","testingMail@gmail.com",
                "",false,0);

        when(request.getParameter("Email")).thenReturn("testing@gmail.com");
        when(request.getParameter("Nome")).thenReturn("Ermene");
        when(request.getParameter("Cognome")).thenReturn("Gildo");
        when(request.getParameter("Boolean")).thenReturn("Ordinario");

        UtenteFormMapper servlet =  new UtenteFormMapper();
        Utente testUser = servlet.map(request,false);
        testUser.setIdUtente(-1);
        assertEquals(testUser,validUtente);

    }
}