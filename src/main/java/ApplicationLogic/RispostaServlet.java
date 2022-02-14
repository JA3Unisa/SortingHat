package ApplicationLogic;

import ApplicationLogic.Http.Alert;
import ApplicationLogic.Http.CommonValidator;
import ApplicationLogic.Http.InvalidRequestException;
import ApplicationLogic.Http.Paginator;
import Storage.Categoria.Categoria;
import Storage.Discussione.Discussione;
import Storage.Discussione.DiscussioneValidator;
import Storage.Discussione.SqlDiscussioneDAO;
import Storage.Risposta.Risposta;
import Storage.Risposta.RispostaFormMapper;
import Storage.Risposta.RispostaValidator;
import Storage.Risposta.SqlRispostaDAO;
import Storage.Utente.Utente;
import Storage.Utente.UtenteSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
/**
 * Servlet dedicata alla gestione delle risposte
 */
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
                    request.getRequestDispatcher(view("AdminGUI/rispostaList")).forward(request, response);
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
                    request.setAttribute("discussione",discussioneList);

                    request.getRequestDispatcher(view("RispostaGUI/RispostaCreate")).forward(request, response);/*MODIFICARE*/
                    break;
                case "/update":
                    authorize(request.getSession(false));
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Risposta> cl=rispostaDAO.fetchRisposte(idUpd);
                    request.setAttribute("risposta",cl.get());
                    List<Discussione>discussioneList1=discussioneDao.fetchDiscussioniAll();
                    request.setAttribute("discussioni",discussioneList1);

                    request.getRequestDispatcher(view("RispostaGUI/RispostaUpdate")).forward(request, response);
                    break;
                case"/delete"://elimino(admin)
                    authorize(request.getSession(false));
                    request.setAttribute("back",view("AdminGUI/discussioneList"));/*MODIFICARE*/
                    validate(RispostaValidator.validateDelete(request));
                    int id2= Integer.parseInt(request.getParameter("id"));

                    if(rispostaDAO.deleteRisposta(id2)) {
                        request.setAttribute("alert", new Alert(List.of("Risposta Rimossa!"), "success"));

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
                    request.setAttribute("back",view("RispostaGUI/RispostaCreate"));

                   UtenteSession ut= (UtenteSession) request.getSession(true).getAttribute("utenteSession");

                    validate(RispostaValidator.validateForm(request,false));

                    Risposta risposta=new RispostaFormMapper().map(request,false);
                    Utente utente=new Utente();
                    utente.setIdUtente(ut.getId());
                    risposta.setUtente(utente);
                    if(rispostaDAO.createRisposta(risposta)){

                        request.setAttribute("risposta",risposta);
                        request.setAttribute("alert",new Alert(List.of("Risposta creata!"),"success"));
                        request.getRequestDispatcher(view("RispostaGUI/RispostaCreate")).forward(request,response);
                    }else{internalError();}
                    break;
                case "/update": //aggiorno(admin)
                    int idUpd= Integer.parseInt(request.getParameter("id"));
                    Optional<Risposta> cl=rispostaDAO.fetchRisposte(idUpd);
                    request.setAttribute("risposta",cl.get());
                    List<Discussione>discussioneList1=discussioneDao.fetchDiscussioniAll();
                    request.setAttribute("discussioni",discussioneList1);

                    authorize(request.getSession(false));
                    if(!errori.isEmpty()){
                        errori.clear();
                    }
                    request.setAttribute("back",view("RispostaGUI/RispostaUpdate"));
                    validate(RispostaValidator.validateForm(request,true));

                    if(errori.isEmpty()){
                    Risposta rispostaAgg=new RispostaFormMapper().map(request,true);
                    UtenteSession ut1= (UtenteSession) request.getSession(true).getAttribute("utenteSession");
                    Utente utente1=new Utente();
                    utente1.setIdUtente(ut1.getId());
                    rispostaAgg.setUtente(utente1);
                    if(rispostaDAO.updateRisposta(rispostaAgg)) {
                        request.setAttribute("risposta",rispostaAgg);
                        request.setAttribute("alert", new Alert(List.of("Risposta Aggiornata!"), "success"));
                        request.getRequestDispatcher(view("RispostaGUI/RispostaUpdate")).forward(request, response);
                    }else internalError();
                    }else{

                         InvalidRequestException invalidRequestException=new InvalidRequestException("ERRORE",errori,HttpServletResponse.SC_BAD_REQUEST);
                        invalidRequestException.handle(request,response);

                    }
                case"/createPost":


                    if(request.getSession(false).getAttribute("utenteSession")== null){

                        request.getRequestDispatcher(view("AutenticazioneGUI/login")).forward(request,response);
                    } else {
                        if(!errori.isEmpty()){
                            errori.clear();
                        }
                        UtenteSession utenteSession = (UtenteSession) request.getSession(false).getAttribute("utenteSession");
                        request.setAttribute("back", view("AutenticazioneGUI/post"));
                        validate(RispostaValidator.validateForm(request, false));

                        if (errori.isEmpty()) {

                            Risposta risposta1 = new Risposta();
                            int idUtente = (utenteSession).getId();
                            Utente utente2 = new Utente();
                            utente2.setIdUtente(idUtente);

                            Discussione discussione = new Discussione();
                            discussione.setIdDiscussione(Integer.parseInt(request.getParameter("idDiscussione")));

                            risposta1.setCorpo(request.getParameter("Corpo"));//modifca
                            risposta1.setDiscussione(discussione);
                            risposta1.setUtente(utente2);//Senza findUtente

                            if (rispostaDAO.createRisposta(risposta1)) {

                                response.sendRedirect("../pages/post?id=" + discussione.getIdDiscussione());//inserire
                            } else {
                                internalError();
                            }
                        } else {

                            int id = Integer.parseInt(request.getParameter("idDiscussione"));
                            Paginator paginator = new Paginator(1,"DiscussioneServlet");

                            Discussione discussione = discussioneDao.fetchDiscussioniByID(id).get();

                            List<Risposta> risposteList =rispostaDAO.fetchRispostaByIdDiscussione(id,paginator);
                            request.setAttribute("discussione",discussione);

                            request.setAttribute("risposte",risposteList);

                            InvalidRequestException invalidRequestException = new InvalidRequestException("ERRORE", errori, HttpServletResponse.SC_BAD_REQUEST);
                            invalidRequestException.handle(request, response);

                        }
                    }

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


