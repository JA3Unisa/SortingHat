package Controller;

import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Risposta.Risposta;
import Model.Risposta.SqlRispostaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "RispostaServlet" , value="/risposte/*")
public class RispostaServlet extends ControllerHttpServlet {
    private SqlRispostaDAO rispostaDAO=new SqlRispostaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/"://show (admin)
                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));

                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "RispostaServlet");
                    System.out.println(paginatore.getLimite());

                    int size = rispostaDAO.countAll();

                    List<Risposta> rispostas = rispostaDAO.fetchRisposta(paginatore);
                    System.out.println(rispostas.get(0).getIdRisposta());
                    request.setAttribute("categorie", rispostas);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("crm/categorie")).forward(request, response);/*MODIFICARE*/
                    break;

                case "/show"://show categoria(admin)
                    authorize(request.getSession(false));
                    validate(CommonValidator.validatePage(request));
                    int id = Integer.parseInt(request.getParameter("id"));
                    Optional<Risposta> categoriaOptional = rispostaDAO.fetchRisposte(id);
                    if (categoriaOptional.isPresent()) {
                        request.setAttribute("risposta", categoriaOptional);
                        request.getRequestDispatcher(view("crm/categoria")).forward(request, response);/*MODIFICARE*/
                    } else {
                        notFound();
                    }
                    break;
                case "/create":
                    authorize(request.getSession(false));
                    request.getRequestDispatcher(view("crm/categoria")).forward(request, response);/*MODIFICARE*/
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Risposta> cl=rispostaDAO.fetchRisposte(idUpd);
                    request.setAttribute("risposta",cl.get());
                    request.getRequestDispatcher(view("categoria/update")).forward(request, response);/*MODIFICARE*/
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

