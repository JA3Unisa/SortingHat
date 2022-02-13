package Storage.Discussione;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DiscussioneFormMapperTest {

    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private DiscussioneFormMapper testMapper = new DiscussioneFormMapper();


    @Test
    public void mapOKTEST() throws SQLException {
        Mockito.when(request.getParameter("Corpo")).thenReturn("Corpo");
        Mockito.when(request.getParameter("Titolo")).thenReturn("Titolo");
        Mockito.when(request.getParameter("Categoria")).thenReturn("3");

        Discussione discussione = testMapper.map(request,false);
        assertEquals(discussione.getCorpo(),"Corpo");
        assertEquals(discussione.getTitolo(),"Titolo");
        assertEquals(discussione.getCategoria().getIdCategoria(),Integer.parseInt("3"));
    }

}