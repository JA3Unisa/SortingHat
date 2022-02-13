package Storage.Categoria;

import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class CategoriaFormMapperTest {
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private CategoriaFormMapper mapperTester = new CategoriaFormMapper();

    @Test
    public void mapOKTEST() {
        Mockito.when(request.getParameter("Nome")).thenReturn("Nome");
        Mockito.when(request.getParameter("Descrizione")).thenReturn("Descrizione");
        Mockito.when(request.getParameter("TitoloDescrizione")).thenReturn("TitoloDescrizione");

        Categoria categoria = mapperTester.map(request,false);
        assertEquals(categoria.getNome(),request.getParameter("Nome"));
        assertEquals(categoria.getDescrizione(),request.getParameter("Descrizione"));
        assertEquals(categoria.getTitoloDescrizione(),request.getParameter("TitoloDescrizione"));
    }
}