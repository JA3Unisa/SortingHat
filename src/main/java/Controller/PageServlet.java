package Controller;


import Controller.Http.InvalidRequestException;
import Model.Utente.SqlUtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PageServlet", value = "/pages/*")
public class PageServlet extends ControllerHttpServlet {
    private SqlUtenteDAO utenteDao = new SqlUtenteDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String path = getPath(request);
            System.out.println("in pages Servlet");
            switch (path) {

                case "/dashboard":
                    System.out.println("dashboard");
                    authorize(request.getSession(false));
                    System.out.println("sessione autorizzata");
                    request.setAttribute("back", view("crm/clienti"));

                    int utenti = utenteDao.countAllUtente();
                    request.setAttribute("clientiNum", utenti);
                    //System.out.println("qua"+clienti);
                    request.getRequestDispatcher(view("crm/home")).forward(request, response);
                    break;
                case "/":
                    request.getRequestDispatcher(view("crm/Home-Page")).forward(request, response);
                    //  request.getRequestDispatcher(view("site/home")).forward(request, response);
                    break;
                case "/regolamento": //show regolamento
                    System.out.println("in regolamento");
                    request.getRequestDispatcher(view("documenti/regolamentiInfo")).forward(request, response);
                    break;
                case "/politiche": //show politiche
                    System.out.println("in politiche");
                    request.getRequestDispatcher(view("documenti/politiche")).forward(request, response);
                    break;
                case "/contattaci": //show info
                    System.out.println("in contattaci");
                    request.getRequestDispatcher(view("documenti/contattaci")).forward(request, response);
                    break;
                default:
                    notFound();
            }
        } catch (InvalidRequestException ex) {
            log(ex.getMessage());
            ex.handle(request, response);
        }catch (SQLException s){
            s.printStackTrace();
        }
    }
}
