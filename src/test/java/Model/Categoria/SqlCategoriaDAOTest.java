package Model.Categoria;

import Controller.Http.Paginator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SqlCategoriaDAOTest {
    private SqlCategoriaDAO testDao = new SqlCategoriaDAO();//Mockito.mock(SqlCategoriaDAO.class);
    private Categoria testCategoria = new Categoria(100,"Test","TestCat",null,"TestTitolo");

    @Before
    void setup() {
    }

    /*CountAll*/
    @Test
    void countAllOKTEST() throws SQLException {
        int firstCount = testDao.countAll();
        testDao.createCategoria(this.testCategoria);
        int lastCount = testDao.countAll();
        List<Categoria> list = testDao.fetchCategoriesAll();
        testDao.deleteCategoria(String.valueOf(list.get(list.size()-1).getIdCategoria()));
        assertEquals(firstCount+1,lastCount);
    }

    /*fetchCategoriesAll*/
    @Test
    void fetchCategoriesAllOKTEST() throws SQLException {
        int firstCount,lastCount;
        List<Categoria> list = testDao.fetchCategoriesAll();
        firstCount = list.size();
        testDao.createCategoria(this.testCategoria);
        list = testDao.fetchCategoriesAll();
        lastCount = list.size();
        testDao.deleteCategoria(String.valueOf(list.get(list.size()-1).getIdCategoria()));
        assertEquals(firstCount+1,lastCount);
    }

    /*fetchCategories (Paginator)*/
    @Test
    void fetchCategoriesByIDOKTEST() throws SQLException {
        testDao.createCategoria(this.testCategoria);
        List<Categoria> list = testDao.fetchCategoriesAll();
        Optional<Categoria> categoria = testDao.fetchCategoriesByID(list.get(list.size()-1).getIdCategoria());
        testDao.deleteCategoria(String.valueOf(categoria.get().getIdCategoria()));
        assertEquals(categoria.get().getNome(),this.testCategoria.getNome());
        assertEquals(categoria.get().getDescrizione(),this.testCategoria.getDescrizione());
    }

    /*createCategoria*/
    @Test
    void createCategoriaOKTEST() throws SQLException {
        assertThrows(NullPointerException.class,()->testDao.createCategoria(null));
    }

    /*fetchCategories(Paginator paginatore)*/
    @Test
    void fetchCategoriesPaginatorOKTEST () throws SQLException {
        int firstCount,lastCount;
        Paginator paginator = new Paginator(1,"CategoriaServlet");
        List<Categoria> list = testDao.fetchCategories(paginator);
        firstCount = list.size();
        testDao.createCategoria(testCategoria);
        list = testDao.fetchCategories(paginator);
        lastCount = list.size();
        Optional<Categoria> categoria = testDao.fetchCategoriesByID(list.get(list.size()-1).getIdCategoria());
        testDao.deleteCategoria(String.valueOf(categoria.get().getIdCategoria()));
        assertEquals(categoria.get().getNome(),this.testCategoria.getNome());
        assertEquals(categoria.get().getDescrizione(),this.testCategoria.getDescrizione());

    }

}