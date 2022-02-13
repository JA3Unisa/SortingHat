package Storage.Utente;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class UtenteFormMapperTest {

    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private UtenteFormMapper mapperTester = new UtenteFormMapper();

    @Test
    public void mapOKTEST() {
        Mockito.when(request.getParameter("Email")).thenReturn("Email");
        Mockito.when(request.getParameter("Nome")).thenReturn("Nome");
        Mockito.when(request.getParameter("Cognome")).thenReturn("Cognome");
        Mockito.when(request.getParameter("Boolean")).thenReturn("Ordinario");

        Utente utente = mapperTester.map(request,false);
        assertEquals(utente.getNome(),request.getParameter("Nome"));
        assertEquals(utente.getCognome(),request.getParameter("Cognome"));
        assertEquals(utente.getEmail(),request.getParameter("Email"));
        assertFalse(utente.getUniversitario());
    }


}