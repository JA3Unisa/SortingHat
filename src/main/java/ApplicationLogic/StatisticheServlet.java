package ApplicationLogic;

import Storage.Categoria.Categoria;
import Storage.Categoria.SqlCategoriaDAO;
import Storage.Contribuisci.Contribuisci;
import Storage.Contribuisci.SqlContribuisciDAO;
import Storage.Predict.Predict;
import Storage.Predict.SqlPredictDAO;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StatisticheServlet", value = "/StatisticheServlet")
public class StatisticheServlet extends ControllerHttpServlet {
    private SqlCategoriaDAO sqlCategoriaDAO = new SqlCategoriaDAO();
    private SqlPredictDAO sqlPredictDAO = new SqlPredictDAO();
    private SqlContribuisciDAO sqlContribuisciDao = new SqlContribuisciDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("ciaoneee");
            List<Categoria> categorie = sqlCategoriaDAO.fetchCategoriesAll();
            List<Predict> predizioni = sqlPredictDAO.fetchAll();
            List<Contribuisci> contributi = sqlContribuisciDao.fetchAll();
            Gson gson = new Gson();
            String categorieJson = gson.toJson(categorie);
            String categoriePredizioni = gson.toJson(predizioni);
            String categorieContribuisci = gson.toJson(contributi);
            ArrayList<Object> ret = new ArrayList<>();
            ret.add(categorie);
            ret.add(predizioni);
            ret.add(contributi);
            String retJson = gson.toJson(ret);
            request.setAttribute("stats", retJson);
            request.getRequestDispatcher(view("documenti/statistiche")).forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
