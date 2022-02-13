package Storage.Risposta;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class RispostaFormMapperTest {
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private RispostaFormMapper mapper = new RispostaFormMapper();

    @Test
    public void mapOKTEST(){
        Mockito.when(request.getParameter("Discussione")).thenReturn("1");
        Mockito.when(request.getParameter("Corpo")).thenReturn("Corpo");

        Risposta r = mapper.map(request,false);
        assertEquals(r.getCorpo(),"Corpo");
        assertNull(r.getUtente().getNome());
        assertNull(r.getUtente().getCognome());
    }
}