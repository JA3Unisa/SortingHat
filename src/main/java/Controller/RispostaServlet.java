package Controller;

import Controller.Http.Alert;
import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.CategoriaFormMapper;
import Model.Categoria.CategoriaValidator;
import Model.Risposta.Risposta;
import Model.Risposta.RispostaFormMapper;
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
                case"/create"://creo(admin)
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("crm/categoria"));/*MODIFICARE*/

                    validate(CategoriaValidator.validateForm(request,false));
                   Risposta risposta=new RispostaFormMapper().map(request,true);
                    if(rispostaDAO.createRisposta(risposta)){
                        System.out.println("creata");
                        request.setAttribute("risposta",risposta);
                        request.setAttribute("alert",new Alert(List.of("Risposta creata!"),"success"));
                        request.getRequestDispatcher(view("user/risposta")).forward(request,response);/*MODIFICARE*/
                    }else{internalError();}
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("categoria/update"));
                    validate(CategoriaValidator.validateForm(request,true));
                   Risposta rispostaAgg=new RispostaFormMapper().map(request,true);
                    System.out.println(rispostaAgg.getIdRisposta());

                    if(rispostaDAO.updateRisposta(rispostaAgg)) {
                        request.setAttribute("risposta",rispostaAgg);
                        request.setAttribute("alert", new Alert(List.of("Risposta Aggiornata!"), "success"));
                        request.getRequestDispatcher(view("risposta/update")).forward(request, response);/*MODIFICARE*/
                    }else{
                        internalError();}
                    break;

                case"/delete"://elimino(admin)
                    System.out.println("in categorie Delete");
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("crm/categoria"));
                    validate(CategoriaValidator.validateDelete(request));
                   int id= Integer.parseInt(request.getParameter("id"));
                    System.out.println("sto per cancellare "+ id);
                    if(rispostaDAO.deleteRisposta(id)) {

                        request.setAttribute("alert", new Alert(List.of("Risposta Rimossa!"), "success"));
                        //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                        request.getRequestDispatcher(view("crm/delete")).forward(request,response);/*MODIFICARE*/
                    }else{internalError();}
                    break;

                default:
                    notAllowed();
                    break;
            }
        } catch (InvalidRequestException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


