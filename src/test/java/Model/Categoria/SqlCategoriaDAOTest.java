package Model.Categoria;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SqlCategoriaDAOTest {
    private SqlCategoriaDAO testDao = new SqlCategoriaDAO();
    private Categoria testCategoria = new Categoria(100,"Test","TestCat",null,"TestTitolo");

    @Test
    void countAllOKTEST() throws SQLException {
        int firstCount = testDao.countAll();
        testDao.createCategoria(this.testCategoria);
        int lastCount =  testDao.countAll();
        assertEquals(firstCount+1,lastCount);
    }

    @Test
    void fetchCategoriesAllOKTEST() throws SQLException {
        int firstCount,lastCount;
        List<Categoria> list = testDao.fetchCategoriesAll();
        firstCount = list.size();
        testDao.createCategoria(this.testCategoria);
        list = testDao.fetchCategoriesAll();
        lastCount = list.size();
        assertEquals(firstCount+1,lastCount);
    }


}