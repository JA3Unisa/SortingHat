package Controller;

import Controller.Http.Alert;
import Controller.Http.CommonValidator;
import Controller.Http.InvalidRequestException;
import Controller.Http.Paginator;
import Model.Categoria.Categoria;
import Model.Categoria.CategoriaFormMapper;
import Model.Categoria.CategoriaValidator;
import Model.Discussione.Discussione;
import Model.Discussione.SqlDiscussioneDAO;
import Model.Risposta.Risposta;
import Model.Risposta.RispostaFormMapper;
import Model.Risposta.RispostaValidator;
import Model.Risposta.SqlRispostaDAO;
import Model.Utente.Utente;
import Model.Utente.UtenteSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.renderable.RenderableImageProducer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name= "RispostaServlet" , value="/risposte/*")
public class RispostaServlet extends ControllerHttpServlet {
    private SqlRispostaDAO rispostaDAO=new SqlRispostaDAO();
    private SqlDiscussioneDAO discussioneDao=new SqlDiscussioneDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            System.out.println(path);
            switch (path) {
                case "/"://show (admin)
                    authorize(request.getSession(false));

                    request.setAttribute("page",1);
                    validate(CommonValidator.validatePage(request));

                    int page = parsePage(request);

                    Paginator paginatore = new Paginator(page, "RispostaServlet");


                    int size = rispostaDAO.countAll();

                    List<Risposta> rispostas = rispostaDAO.fetchRisposta(paginatore);

                    request.setAttribute("risposte", rispostas);
                    request.setAttribute("pages", paginatore.getPages(size));
                    request.getRequestDispatcher(view("admin/rispostaList")).forward(request, response);
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
                    List<Discussione>discussioneList=discussioneDao.fetchDiscussioniAll();
                    request.setAttribute("discussioni",discussioneList);

                    request.getRequestDispatcher(view("Risposta/RispostaCreate")).forward(request, response);/*MODIFICARE*/
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Risposta> cl=rispostaDAO.fetchRisposte(idUpd);
                    request.setAttribute("risposta",cl.get());
                    List<Discussione>discussioneList1=discussioneDao.fetchDiscussioniAll();
                    request.setAttribute("discussioni",discussioneList1);

                    request.getRequestDispatcher(view("Risposta/RispostaUpdate")).forward(request, response);
                    break;
                case"/delete"://elimino(admin)
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("admin/discussioneList"));/*MODIFICARE*/
                    validate(RispostaValidator.validateDelete(request));
                    int id2= Integer.parseInt(request.getParameter("id"));
                    System.out.println("sto per cancellare "+ id2);
                    if(rispostaDAO.deleteRisposta(id2)) {
                        request.setAttribute("alert", new Alert(List.of("Risposta Rimossa!"), "success"));
                        //request.getRequestDispatcher(view("crm/categoria")).forward(request, response);
                        //  request.getRequestDispatcher(view("admin/delete")).forward(request,response);
                        response.sendRedirect("../risposte/?page=1");
                    }else{internalError();}
                    break;


                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Risorsa non trovata");

            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case"/create"://creo(admin)
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("Risposta/RispostaCreate"));
                   UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");

                    validate(RispostaValidator.validateForm(request,false));

                    Risposta risposta=new RispostaFormMapper().map(request,false);
                    Utente utente=new Utente();
                    utente.setIdUtente(ut.getId());
                    risposta.setUtente(utente);
                    if(rispostaDAO.createRisposta(risposta)){
                        System.out.println("creata");
                        request.setAttribute("risposta",risposta);
                        request.setAttribute("alert",new Alert(List.of("Risposta creata!"),"success"));
                        request.getRequestDispatcher(view("Risposta/RispostaCreate")).forward(request,response);
                    }else{internalError();}
                    break;
                case "/update": //aggiorno(admin)

                    authorize(request.getSession(false));
                    request.setAttribute("back",view("Risposta/RispostaUpdate"));
                    validate(RispostaValidator.validateForm(request,true));

                    Risposta rispostaAgg=new RispostaFormMapper().map(request,true);
                    UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    Utente utente1=new Utente();
                    utente1.setIdUtente(ut1.getId());
                    rispostaAgg.setUtente(utente1);
                    if(rispostaDAO.updateRisposta(rispostaAgg)) {
                        request.setAttribute("risposta",rispostaAgg);
                        request.setAttribute("alert", new Alert(List.of("Risposta Aggiornata!"), "success"));
                        request.getRequestDispatcher(view("Risposta/RispostaUpdate")).forward(request, response);
                    }else{
                        internalError();}
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


