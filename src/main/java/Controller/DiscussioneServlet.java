package Controller;

import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Discussione.Discussione;
import Model.Discussione.SqlDiscussioneDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "DiscussioneServlet" , value="/discussioni/*")
public class DiscussioneServlet extends ControllerHttpServlet {
    private SqlDiscussioneDAO discussioneDAO=new SqlDiscussioneDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/": //show discussione admin
                //crearle
                //update
                //delete
                    System.out.println(" discussione pre");
                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));

                    System.out.println(" discussione post");
                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "DiscussioneServlet");
                    System.out.println(paginatore.getLimite());

                    int size = discussioneDAO.countAll();
                    System.out.println("X" + paginatore.getPages(size));
                    List<Discussione> discussiones = discussioneDAO.fetchDiscussioni(paginatore);
                    System.out.println(discussiones.get(0).getIdCategoria());
                    request.setAttribute("categorie", discussiones);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("crm/categorie")).forward(request, response);
                    break;

                case "/show"://show categoria(admin)
                    authorize(request.getSession(false));
                    validate(CommonValidator.validatePage(request));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Optional<Discussione> categoriaOptional = discussioneDAO.fetchDiscussioniByID(id);
                    if (categoriaOptional.isPresent()) {
                        request.setAttribute("categoria", categoriaOptional);           //modificare
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
                    Optional<Discussione> cl=discussioneDAO.fetchDiscussioniByID(idUpd);
                    request.setAttribute("discussione",cl.get());
                    request.getRequestDispatcher(view("discussione/update")).forward(request, response);
                    break;



                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");



            }
        } catch (InvalidRequestException | SQLException e) {
            e.printStackTrace();
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
