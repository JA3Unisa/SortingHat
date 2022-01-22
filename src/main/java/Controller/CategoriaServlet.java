package Controller;

import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.SqlCategoriaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "CategoriaServlet" , value="/categorie/*")
public class CategoriaServlet extends ControllerHttpServlet {
    private SqlCategoriaDAO categoriaDAO=new SqlCategoriaDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/"://show categorie(admin)
                    System.out.println(" categoria pre");
                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));

                    System.out.println(" categoria post");
                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "CategoriaServlet");
                    System.out.println(paginatore.getLimite());

                    int size = categoriaDAO.countAll();
                    System.out.println("X" + paginatore.getPages(size));
                    List<Categoria> categorie = categoriaDAO.fetchCategories(paginatore);
                    System.out.println(categorie.get(0).getIdCategoria());
                    request.setAttribute("categorie", categorie);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("crm/categorie")).forward(request, response);
                    break;

                case "/show"://show categoria(admin)
                    authorize(request.getSession(false));
                    validate(CommonValidator.validatePage(request));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Optional<Categoria> categoriaOptional = categoriaDAO.fetchCategoriesByID(id);
                    if (categoriaOptional.isPresent()) {
                        request.setAttribute("categoria", categoriaOptional);
                        request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                    } else {
                        notFound();
                    }
                    break;
                case "/create":
                    authorize(request.getSession(false));
                    request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Categoria> cl=categoriaDAO.fetchCategoriesByID(idUpd);
                    request.setAttribute("categoria",cl.get());
                    request.getRequestDispatcher(view("categoria/update")).forward(request, response);
                    break;

                case "/prodotti":
                    request.getRequestDispatcher(view("site/search")).forward(request, response);
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");

            }
        } catch (SQLException throwables) {
            log(throwables.getMessage());
        }catch (InvalidRequestException ex){
            log(ex.getMessage());
            ex.handle(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {

                default:
                    notAllowed();
                    break;
            }
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }
}


